package com.example.persistence

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.persistence.ui.theme.PersistenceTheme

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            PersistenceTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    ThemeApp()
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun ThemeApp() {
//
//    val themePreferences = ThemePreferences(LocalContext.current)
//    var selectedTheme by remember { mutableStateOf(themePreferences.getTheme() ?: "Light") }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(text = "Select Theme")
//
//        Button(onClick = {
//            selectedTheme = "Light"
//            themePreferences.saveTheme(selectedTheme)
//        }) {
//            Text("Light Theme")
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(onClick = {
//            selectedTheme = "Dark"
//            themePreferences.saveTheme(selectedTheme)
//        }) {
//            Text("Dark Theme")
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Text(text = "Current Theme: $selectedTheme")
//    }
//
//}

// Fastest method of data retrieval with ORM (like Room) is ODBC/DB Helper

class MainActivity : ComponentActivity() {
    private lateinit var dbHelper: DBHelper // This line ...
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dbHelper = DBHelper(this) // and this line, make the DB helper object. It's global but also private.
        setContent {
            PersistenceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyDatabaseApp()
                }
            }
        }
    }
    @Composable
    fun MyDatabaseApp() {
        var username by remember { mutableStateOf("") }
        var userAge by remember { mutableStateOf("") }
        var userList by remember { mutableStateOf(listOf<String>()) }
        var userID by remember { mutableStateOf("") }

        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("User Name") }
            )

            TextField(
                value = userAge,
                onValueChange = { userAge = it },
                label = { Text("User Age") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )


            Button(
                onClick = {
                    dbHelper.insertUser(username, userAge.toInt())
                    userList = dbHelper.getAllUsers()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Add User")
            }

            TextField(
                value = userID,
                onValueChange = { userID = it },
                label = { Text("User ID") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )

            Button(
                onClick = {
                    dbHelper.deleteUser(userID.toInt())
                    userList = dbHelper.getAllUsers()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Delete User")
            }

            LazyColumn {
                items(userList) { user ->
                    Text(text = user)
                }
            }
        }
    }
}

