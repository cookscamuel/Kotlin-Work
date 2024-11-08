package com.example.cakeapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.cakeapp.ui.theme.CakeAppTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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

/*
    Author: Samuel Cook
    Date: October 29, 2024
    Project: Cake Ordering App
    Filename: Classes.kt
    Purpose: File to hold all classes. Navigation is
             featured here through intents. Non-
             Composable functions are also kept in
             this file.
 */

// This class displays a registry screen for the
// user to create an account. Since this is just
// a simple project, all that happens here is
// variables holding the user's input.
class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CakeAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    var name by remember { mutableStateOf("") }
                    var email by remember { mutableStateOf("") }
                    var password by remember { mutableStateOf("") }

                    // These have values by default to fix a problem I was
                    // having where the page thought the fields were acceptable
                    // before any input was entered
                    var nameError by remember { mutableStateOf(" ") }
                    var emailError by remember { mutableStateOf(" ") }
                    var passwordError by remember { mutableStateOf(" ") }

                    var success by remember { mutableStateOf(false) }


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

                            // A row to arrange the title of the page
                            Row(Modifier.padding(25.dp)) {

                                // decorative cake image
                                Image(
                                    modifier = Modifier
                                        .size(80.dp),
                                    painter = painterResource(id = R.drawable.cake4),
                                    contentDescription = "A small cake clip-art."
                                )

                                // Title for the page
                                Text(
                                    text = "Register",
                                    Modifier.padding(8.dp, 0.dp, 8.dp, 0.dp),
                                    fontSize = 55.sp,
                                    color = Color(0xFF4599ff),
                                    fontWeight = FontWeight.ExtraBold,
                                    fontFamily = FontFamily.Cursive,
                                    fontStyle = FontStyle.Italic,
                                    textAlign = TextAlign.Center,
                                    letterSpacing = 3.sp
                                )

                                // The row places the cake next to the title
                            }

                            // Subtitle text
                            Text(
                                text = "Create your Account!",
                                color = Color.Black,
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.ExtraBold,
                                fontFamily = FontFamily.Serif,
                                modifier = Modifier.padding(0.dp, 0.dp, 18.dp, 0.dp)
                            )

                            Spacer(modifier = Modifier.height(15.dp))

                            TextField(
                                value = name,
                                onValueChange = {
                                    name = it
                                    nameError =
                                        if (it.isBlank()) "Please Enter Your Name Here." else ""
                                },
                                label = { Text("Name") }
                            )
                            if (nameError.isNotEmpty()) Text(
                                text = nameError,
                                color = MaterialTheme.colorScheme.error
                            )

                            Spacer(modifier = Modifier.height(15.dp))

                            TextField(
                                value = email,
                                onValueChange = {
                                    email = it
                                    emailError =
                                        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(it)
                                                .matches()
                                        ) "Invalid email!" else ""
                                },
                                label = { Text("Email") },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                            )
                            if (emailError.isNotEmpty()) Text(
                                text = emailError,
                                color = MaterialTheme.colorScheme.error
                            )

                            Spacer(modifier = Modifier.height(15.dp))

                            TextField(
                                value = password,
                                onValueChange = {
                                    password = it
                                    val passwordPattern = Regex("^[a-zA-Z0-9@_]+$")

                                    passwordError = when {
                                        it.length < 8 -> "Password must be at least 8 characters long."
                                        !passwordPattern.matches(it) -> "Must use only letters, numbers, @, and _"
                                        else -> ""
                                    }
                                },
                                label = { Text("Password") },
                                visualTransformation = PasswordVisualTransformation(),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                            )
                            if (passwordError.isNotEmpty()) Text(
                                text = passwordError,
                                color = MaterialTheme.colorScheme.error
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            Button(onClick = {
                                val valid = validateForm(
                                    nameError,
                                    emailError,
                                    passwordError
                                )
                                if (valid) {
                                    success = true
                                }

                                if (success) {
                                    val navigate = Intent(this@RegisterActivity, LoginActivity::class.java)
                                    navigate.putExtra("email", email)
                                    navigate.putExtra("password", password)
                                    startActivity(navigate)
                                }
                            })

                            {
                                Text("Sign Up")
                            }

                        }
                    }
                }
            }
        }
    }
}

// Class that allows the user to attempt a login.
// Because the scope of this project is so small,
// the only correct login credentials are the
// previously entered email and password from
// when the user registers in the previous
// activity.
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CakeAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val email = intent.getStringExtra("email")
                    val password = intent.getStringExtra("password")

                    var tempEmail by remember { mutableStateOf("") }
                    var tempPass by remember { mutableStateOf("") }
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

                            Row(Modifier.padding(25.dp)) {

                                Image(
                                    modifier = Modifier
                                        .size(80.dp),
                                    painter = painterResource(id = R.drawable.cake2),
                                    contentDescription = "A small cake clip-art."
                                )

                                // Title for the page
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

                            Spacer(modifier = Modifier.height(15.dp))

                            TextField(

                                value = tempEmail,
                                onValueChange = { tempEmail = it },
                                label = { Text("Email") },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)

                            )

                            Spacer(modifier = Modifier.height(15.dp))

                            TextField(

                                value = tempPass,
                                onValueChange = { tempPass = it },
                                label = { Text("Password") },
                                visualTransformation = PasswordVisualTransformation(),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)

                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            Button(onClick = {

                                if (tempEmail == email && tempPass == password) {
                                    val navigate = Intent(this@LoginActivity, CakeAppActivity::class.java)
                                    startActivity(navigate)
                                }
                                else {
                                    failMessage = "Login Failed: Incorrect username or password, please try again."
                                }
                            })

                            {
                                Text("Sign In")
                            }

                            Text(text = failMessage,
                                color = MaterialTheme.colorScheme.error,
                                textAlign = TextAlign.Center)
                        }
                    }
                }
            }
        }
    }
}

// Class that simply calls the main cake application and its screens/nav bar.
class CakeAppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                CakeAppNavigation()
            }
        }
    }
}

// Non-Composable functions used throughout the project.

// Function used to validate the user's account prior to creation.
fun validateForm(nameError: String, emailError: String, passwordError: String): Boolean {
    return nameError.isEmpty() && emailError.isEmpty() && passwordError.isEmpty()
}

// Function used to calculate the total cost of a user's order in the Order screen.
fun calculateTotal(qty: String): String {

    return if (qty.toIntOrNull() != null) {
        val subtotal = (qty.toInt() * 9.99).toString()
        "SUBTOTAL: $$subtotal\nORDER SUCCESSFULLY PLACED"

    } else {
        "ERROR: invalid quantity! (please enter an integer value)"
    }
}