package com.example.buttons

import android.icu.text.Transliterator.Position
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.buttons.ui.theme.ButtonsTheme
import kotlinx.coroutines.delay

// use the asterisk to be more efficient with your import statements.

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ButtonsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {

                        // within Surface is where the function is called.
                        // this is the main function.
                        TextDemo()

                }
            }
        }
    }
}

@Composable
fun TextDemo() {

    var outline by remember { mutableStateOf("") }
    var simple by remember { mutableStateOf("")}

    // variable for button submission
    var isSubmitted by remember { mutableStateOf(false)}

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    )
    // This looks awful, but remember, it's just parameters.

    {

        OutlinedTextField(

            value = outline,
            onValueChange = { outline = it },
            label = { Text("Enter text") },
            modifier = Modifier.fillMaxWidth()

        )
        // It's just parameters. Don't worry.


        Spacer(modifier = Modifier.height(30.dp))
        // this can kind of be used like a <br> in HTML

        TextField(

            value = simple,
            onValueChange = { simple = it },
            label = { Text("Enter more text.") },
            modifier = Modifier.fillMaxWidth()
            
        )

        // Regular button
        Button( onClick =  { isSubmitted = true },
            modifier = Modifier.width(200.dp)) {
            Text(simple)
        }

        // Elevated button
        ElevatedButton( onClick =  { }) {
            Text("Elevated")
        }

        // Outlined button
        OutlinedButton( onClick =  { }) {
            Text("Outlined")
        }

        // Text button
        TextButton( onClick =  { }) {
            Text("Text Button")
        }


            Spacer(modifier = Modifier.height(30.dp))


        if (isSubmitted && outline.isNotEmpty() && simple.isNotEmpty()) {

            Text(
                text = "$outline $simple",
                modifier = Modifier.background(Color.White),
                fontSize = 50.sp,
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle.Italic
            )

        }
        else {
            Text("Nothing to see here!")
        }

    }
}

@Preview
@Composable
fun PreviewTextDemo() {
    ButtonsTheme { // This tells the preview to use the theme from Line 26
        TextDemo()
    }
}
