package com.example.loginscreen

import android.content.Intent
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
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginscreen.ui.theme.LoginScreenTheme

class User (private val validUsername: String, private val validPassword: String) {
    fun login(inputUsername: String, inputPassword: String): String {

        // this if statement decides what to return, interesting.
        return if (inputUsername == validUsername && inputPassword == validPassword) {
            "Login Successful!"
        }
        else {
            "Login Failed: Username or Password Incorrect."
        }
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreenTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginPage(context = this@MainActivity)
                    // context refers to the current scope of the project
                    // I don't completely understand what this means.
                }
            }
        }
    }
}

@Composable
fun LoginPage(context: ComponentActivity) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var welcomeMessage by remember { mutableStateOf("") }

    val user = User("admin", "admin")
    // this is making an object for the class at the top of the file.

    Column(Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        TextField(

            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)

        )

        Spacer(modifier = Modifier.height(30.dp))

        TextField(

            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)

        )

        Button( onClick =  {
            welcomeMessage = user.login(username, password)
            if (welcomeMessage == "Login Successful!") {

                val intent = Intent(context, HomeActivity::class.java)
                context.startActivity(intent)
                // this tells the program to switch to the next context,
                // which is the next activity.

            }
        },
            modifier = Modifier
                .width(200.dp)
                .align(Alignment.CenterHorizontally)) {
            Text("Login")
        }

    }
}

@Preview
@Composable
fun DisplayPage() {
    LoginPage(context = MainActivity())
}
