package com.example.cakeapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        const val DATABASE_NAME = "MyDatabase.db"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "Users"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_AGE = "age"
    }
    /*
        A specific type of object that is used to access the methods/attributes
        of an object, but do not need/want an actual instance of the class it is
        an object of.
    */

    // Always have an onCreate function
    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMN_NAME TEXT, $COLUMN_AGE INTEGER)"
        db.execSQL(createTable)
    }

    // Always have an onUpgrade function
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // If upgrading, drop the table and replace it.
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    /*
        You can also check with an if statement if the old version
        is less than the new version. This way it will only
        execute code if it is relevant.
     */

    fun insertUser(name: String, age: Int): Boolean {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, name)
            put(COLUMN_AGE, age)
        }

        val result = db.insert(TABLE_NAME, null, values) // nullColumnHack enters null values by default if the database design allows null values.
        db.close()
        return result != -1L
    }
    /*
        If you don't want to use the db.insert() function, you can make a variable with the query written out
        You can then call the db.execSQL(variable).

        Essentially, insert() is doing the same thing that is happening in the onCreate function.
     */

    fun getAllUsers(): List<String> {
        val db = this.readableDatabase
        val cursor = db.query(TABLE_NAME, arrayOf(COLUMN_NAME, COLUMN_AGE), null, null, null, null, null)
        // These nulls can be replaced with modifiers (group by, order by, where, like, etc.)

        val users = mutableListOf<String>()

        if (cursor.moveToNext()) {
            do {
                val name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME))
                val age = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_AGE))
                users.add("Name: $name, Age: $age")
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return users
    }

    fun deleteUser(userID: Int): Boolean {
        val db = this.writableDatabase
        val result = db.delete(
            TABLE_NAME,
            "$COLUMN_ID = ?",
            arrayOf(userID.toString())
        )
        db.close()
        return result > 0
    }

    fun updateUser(userID: Int, newName: String, newAge: Int): Boolean {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, newName)
            put(COLUMN_AGE, newAge)
        }

        val result = db.update(
            TABLE_NAME,
            values,
            "$COLUMN_ID = ?",
            arrayOf(userID.toString())
        )
        db.close()
        return result > 0
    }
}