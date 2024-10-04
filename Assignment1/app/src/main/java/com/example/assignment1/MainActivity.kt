package com.example.assignment1

/*
    Author: Samuel Cook
    Course: MOBI3002
    Date: September 20, 2024
    Purpose: Display three blocks of text with different styles.
*/

// import statements
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.assignment1.ui.theme.Assignment1Theme

// the main activity, used by the emulator.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment1Theme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    // this is the overall theme for the activity, used when rendering the preview and also displaying the functions in the emulator.

                    DisplayText()
                    // this is the function call for the below function that displays UI elements.

                }
            }
        }
    }
}


// This function is composable because it involves UI elements.
@Composable
fun DisplayText(modifier: Modifier = Modifier) {


    Column ( // display the contents in the format of a column.
        modifier = modifier
            .background(Color(0xFFf0f0f0)) // set the background color of the column using hexadecimal.
            .fillMaxSize() // fill the entire screen with this column.
            .padding(20.dp), // specify the padding from the sides of the screen for the contents inside the column.
        verticalArrangement = Arrangement.Center, // align each text container to be vertically centered.
        horizontalAlignment = Alignment.CenterHorizontally, // align each container to be horizontally centered.
    ) {

        Text( // used to display my name on the screen.
            text = "Samuel", // specify the text to be displayed on the screen.
            modifier = Modifier.background(Color.White) // set a background color of white.
                .padding(12.dp), // specify the padding between the text and the edges of the container.
            fontSize = 50.sp, // specify the font size in sp.
            color = Color.Red, // set the text color to Red.
            fontWeight = FontWeight.Bold, // specify the weight of the text.
            fontFamily = FontFamily.SansSerif, // specify the font of the text.
            fontStyle = FontStyle.Italic, // style the text with italics.
            textAlign = TextAlign.Center // center the text to the middle of its container.
            )

        Text( // second text display to show the program I am in.
            // stylings below are similar to the ones used in the above Text element.
            text = "IT Programming at NSCC explores various programming languages " +
                    "and industry standards on writing code.",
            modifier = Modifier
                .padding(top = 20.dp, bottom = 20.dp)
                .background(Color.White)
                .padding(12.dp),
            fontSize = 20.sp,
            color = Color(0xFF008000), // specify the color of the text with a hex value.
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center,
            lineHeight = 30.sp // specify how many units apart the lines should be spaced.
        )

        Text( // third text display to show a description of what subject I am studying.
            text = "I'm currently studying Mobile Applications for Android.",
            modifier = Modifier.background(Color.White)
                .padding(8.dp),
            fontSize = 25.sp,
            color = Color(0xFF0047AB),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            lineHeight = 35.sp
        )
    }
}

// This is the preview function, it allows for a real-time preview of the activity.
@Preview // keyword to specify that the function is a preview.
@Composable // composable because it involves UI elements
fun DisplayTextPreview() {
    Assignment1Theme {
        // this tells the preview function to display the result of DisplayText using the theme specified in Surface.

        DisplayText() // call the DisplayText function for the preview.
    }
}