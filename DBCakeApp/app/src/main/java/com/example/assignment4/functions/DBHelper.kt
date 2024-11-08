package com.example.persistence

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        const val DATABASE_NAME = "orders.db"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME1 = "Users"
        const val COLUMN_ID1 = "userId"
        const val COLUMN_NAME1 = "name"

        const val TABLE_NAME2 = "Item"
        const val COLUMN_ID2 = "itemId"
        const val COLUMN_NAME2 = "itemName"
        const val COLUMN_PRICE = "price"

        const val TABLE_NAME3 = "Orders"
        const val COLUMN_ID3 = "orderId"
        const val COLUMN_QTY = "quantity"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable1 = "CREATE TABLE $TABLE_NAME1 ($COLUMN_ID1 INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMN_NAME1 TEXT)"
        val createTable2 = "CREATE TABLE $TABLE_NAME2 ($COLUMN_ID2 INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMN_NAME2 TEXT, $COLUMN_PRICE DOUBLE)"
        val createTable3 = "CREATE TABLE $TABLE_NAME3 ($COLUMN_ID3 INTEGER PRIMARY KEY AUTOINCREMENT, FOREIGN KEY ($COLUMN_NAME1) REFERENCES $TABLE_NAME1($COLUMN_NAME1), FOREIGN KEY ($COLUMN_NAME2) REFERENCES $TABLE_NAME2($COLUMN_NAME2), $COLUMN_QTY INTEGER)"
        db.execSQL(createTable1)
        db.execSQL(createTable2)
        db.execSQL(createTable3)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME1")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME2")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME3")
        onCreate(db)
    }

    fun insertUser(name: String): Boolean {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME1, name)
        }

        val result = db.insert(TABLE_NAME1, null, values)
        db.close()
        return result != -1L
    }


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