package com.example.assignment4.classes

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment4.ui.theme.Assignment4Theme
import com.example.assignment4.R

/*
    Author: Samuel Cook
    Date: October 29, 2024
    Project: Cake Ordering App
    Filename: LoginActivity.kt
    Purpose: Class that handles the login screen.
 */

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment4Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    // Because the scope of this project is so small,
                    // the only correct login credentials are the
                    // previously entered email and password from
                    // when the user registers in the previous
                    // activity.
                    val email = intent.getStringExtra("email")
                    val password = intent.getStringExtra("password")
                    // Again, not safe, but simple for simulation.

                    // mutable state variables to hold the users attempts at logging in.
                    var tempEmail by remember { mutableStateOf("") }
                    var tempPass by remember { mutableStateOf("") }

                    // mutable state variable to display a failed login message to the user.
                    var failMessage by remember { mutableStateOf("") }

                    Column(
                        Modifier
                            .fillMaxSize()
                            .background(Color(0xFFe7a6ff))
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(6.dp)
                                .background(Color(0xFFffebfe)),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            // Row containing the title for the page.
                            Row(Modifier.padding(25.dp)) {

                                Image(
                                    modifier = Modifier
                                        .size(80.dp),
                                    painter = painterResource(id = R.drawable.cake2),
                                    contentDescription = "A small cake clip-art."
                                )

                                Text(
                                    text = "Login",
                                    Modifier.padding(8.dp, 0.dp, 8.dp, 0.dp),
                                    fontSize = 55.sp,
                                    color = Color(0xFF4599ff),
                                    fontWeight = FontWeight.ExtraBold,
                                    fontFamily = FontFamily.Cursive,
                                    fontStyle = FontStyle.Italic,
                                    textAlign = TextAlign.Center,
                                    letterSpacing = 3.sp
                                )

                            }

                            // Text function to display subtitle.
                            Text(
                                text = "Welcome! Please sign in.",
                                color = Color.Black,
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.ExtraBold,
                                fontFamily = FontFamily.Serif,
                                modifier = Modifier.padding(0.dp, 0.dp, 18.dp, 0.dp)
                            )

                            Spacer(modifier = Modifier.height(15.dp))

                            // Textfield for the user to enter an email
                            TextField(

                                value = tempEmail,
                                onValueChange = { tempEmail = it },
                                label = { Text("Email") },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                                // keyboardOptions sets up the keyboard for email entry format.
                            )

                            Spacer(modifier = Modifier.height(15.dp))

                            // Textfield for the user to enter a password.
                            TextField(

                                value = tempPass,
                                onValueChange = { tempPass = it },
                                label = { Text("Password") },
                                visualTransformation = PasswordVisualTransformation(),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)

                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            // Button to login
                            Button(onClick = {

                                // Check to see if the user entered a correct email and password combination
                                if (tempEmail == email && tempPass == password) {
                                    val navigate = Intent(this@LoginActivity, CakeAppActivity::class.java)
                                    startActivity(navigate)
                                    // if they did, navigate to the CakeAppActivity class, which starts the main cake app.
                                }
                                else {
                                    failMessage = "Login Failed: Incorrect username or password, please try again."
                                    // if they enter invalid credentials, display an error message.
                                }
                                // I figured a simple if statement was sufficient for this segment because
                                // this login is just a simulation. If it were a real, live app with many users,
                                // I would involve a database to store users and also introduce tighter security
                                // and authorization measures.
                            })

                            {
                                Text("Sign In")
                            }

                            Text(text = failMessage,
                                color = MaterialTheme.colorScheme.error,
                                textAlign = TextAlign.Center)
                            // this is the text function that displays the error message.
                            // by default, the message is "", but on a failed attempt it
                            // becomes the error message.
                        }
                    }
                }
            }
        }
    }
}