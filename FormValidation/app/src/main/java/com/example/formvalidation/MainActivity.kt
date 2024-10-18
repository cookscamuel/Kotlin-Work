package com.example.formvalidation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.formvalidation.ui.theme.FormValidationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FormValidationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignUpForm()
                }
            }
        }
    }
}


@Composable
fun SignUpForm() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }
    var isFrenchChecked by remember { mutableStateOf(false) }
    var isEnglishChecked by remember { mutableStateOf(false) }
    var isAgreed by remember { mutableStateOf(false) }
    var showWelcome by remember { mutableStateOf(false) }


    var nameError by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }
    var birthDateError by remember { mutableStateOf("") }
    var termsError by remember { mutableStateOf("") }


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {

        TextField(value = name, onValueChange = {
            name = it
            nameError = if (it.isBlank()) "Name cannot be blank!" else ""
        }, label = { Text("Name") }
        )
        if (nameError.isNotEmpty()) Text(text = nameError, color = MaterialTheme.colorScheme.error)


        TextField(value = email, onValueChange = {
            email = it
            emailError = if(!android.util.Patterns.EMAIL_ADDRESS.matcher(it).matches()) "Invalid email!" else ""
        },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)) // keyboard options makes the @ appear on the first keyboard.
        if (emailError.isNotEmpty()) Text(text = emailError, color = MaterialTheme.colorScheme.error)


        TextField(
            value = password,
            onValueChange = {
                password = it
                val passwordPattern = Regex("^[a-zA-Z0-9@_]+$")

                passwordError = when {
                    it.length < 8 -> "Password must be at least 8 characters!"
                    !passwordPattern.matches(it) -> "Password can only contain letters, numbers, @, and _."
                    else -> ""
                }
            },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(), // makes password look like circles in the entry field
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        if (passwordError.isNotEmpty()) Text(text = passwordError, color = MaterialTheme.colorScheme.error)


        TextField(
            value = birthDate,
            onValueChange = {
                birthDate = it
                birthDateError = if (it.isBlank()) "Birth date cannot be empty!" else ""
            },
            label = { Text("Birthdate (YYYY-MM-DD)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        if (birthDateError.isNotEmpty()) Text(text = birthDateError, color = MaterialTheme.colorScheme.error)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Gender")
        Row {
            RadioButton(selected = selectedGender == "Male", onClick = { selectedGender = "Male" })
            Text("Male")
            Spacer(modifier = Modifier.width(8.dp))
            RadioButton(selected = selectedGender == "Female", onClick = { selectedGender = "Female" })
            Text("Female")
            Spacer(modifier = Modifier.width(8.dp))
            RadioButton(selected = selectedGender == "Other", onClick = { selectedGender = "Other" })
            Text("Other")
        }
        if (selectedGender.isBlank()) Text(text = "Please select your Gender", color = MaterialTheme.colorScheme.error)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Language:")
        Row {

            Checkbox(checked = isFrenchChecked, onCheckedChange = { isFrenchChecked = it} )
            Text("French")
            Checkbox(checked = isEnglishChecked, onCheckedChange = { isEnglishChecked = it} )
            Text("English")

        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(checked = isAgreed, onCheckedChange = {
                isAgreed = it
                termsError = if (!it) "You must sell your soul to us!" else ""
            })
            Text("Agree to the Terms of Service")
        }
        if (termsError.isNotEmpty()) Text(text = termsError, color = MaterialTheme.colorScheme.error)

        Spacer(modifier = Modifier.height(16.dp))


        Button(onClick = {
            val valid = validateForm(
                nameError,
                emailError,
                passwordError,
                birthDateError,
                selectedGenderError = if (selectedGender.isBlank()) "Please select your Gender" else "",
                isAgreed
            )
            if (valid) {
                showWelcome = true
            }
        }) {
            Text("Sign Up!")
        }

        if (showWelcome) {
            Text(text = "Welcome, $name!")
        }
    }
}

fun validateForm(
    nameError: String, emailError: String, passwordError: String, birthDateError: String,
    selectedGenderError: String, isAgreed: Boolean): Boolean {
    return nameError.isEmpty() && emailError.isEmpty() && passwordError.isEmpty() &&
            birthDateError.isEmpty() && selectedGenderError.isEmpty() && isAgreed
}

@Preview
@Composable
fun DisplayPreview() {
    SignUpForm()
}