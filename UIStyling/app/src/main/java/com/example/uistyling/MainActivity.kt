package com.example.uistyling

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uistyling.ui.theme.UIStylingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UIStylingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UITest()
                }
            }
        }
    }
}

@Composable
fun UITest() {


    var buttonText by remember { mutableStateOf("") }

    var isSubmitted by remember { mutableStateOf(false) }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {

        Box(
            Modifier
                .padding(20.dp)
                .background(Color.LightGray)
                .weight(1f)
                .clip(RoundedCornerShape(25.dp))
                .fillMaxSize()
        ) {


            Row(
                Modifier.background(Color.Magenta)

            ) {

                Text(
                    text = "Hey HEY Hey HEY Hey HEY",
                    Modifier.background(Color.White)
                )

            }

        }
        Box(
            Modifier
                .padding(20.dp)
                .background(Color.LightGray)
                .weight(1f)
                .clip(RoundedCornerShape(20.dp))
                .fillMaxSize()
        ) {

            Row(
                Modifier.background(Color.Black)

            ) {
                Text(
                    text = "What's up?",
                    Modifier.background(Color.Green)
                )
            }
        }

        TextField(

            value = buttonText,
            onValueChange = { buttonText = it },
            label = { Text("Enter more text.") },
            modifier = Modifier.fillMaxWidth()

        )

        // Regular button
        Button( onClick =  { isSubmitted = true },

            modifier = Modifier.width(200.dp)) {
            if (isSubmitted) {
                Text(buttonText)
            }
            else {
                Text("Submit")
            }
        }

    }
}

@Composable
@Preview
fun PreviewUITest() {
    UITest()
}
