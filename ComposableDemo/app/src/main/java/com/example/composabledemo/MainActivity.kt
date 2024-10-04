package com.example.composabledemo

import android.icu.text.Transliterator.Position
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composabledemo.ui.theme.ComposableDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                Box (
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black),
                    contentAlignment = Alignment.Center

                ) {

                    Greeting()
                } }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {

    val color1 = Color.Blue

    val fontSize1 = 40.sp
    // variables storing color and font size

    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

        Text(
            text = "Samuel",
            modifier = modifier.padding(bottom = 50.dp),
            fontSize = fontSize1, // changes the font size
            color = Color.Green, // changes the color of the text
            fontWeight = FontWeight.Bold, // set the font weight
            fontFamily = FontFamily.Cursive, // set the font style
            fontStyle = FontStyle.Italic
        )
        Text(
            text = "IT Programming at NSCC explores various programming languages " +
                    "and industry standards on writing code.",
            modifier = modifier,
            fontSize = 30.sp, // changes the font size
            color = color1, // changes the color of the text
            fontWeight = FontWeight.Bold, // set the font weight
            fontFamily = FontFamily.Serif, // set the font style
            textAlign = TextAlign.Center
        )

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposableDemoTheme {
        Greeting()
    }
}

/*
    NOTES ON THE ASSIGNMENT
    Display three messages styled differently.
    Different colors, font sizes, background color.
    can be one function to access all values.
    Just a text file with the code, and a screenshot of the emulator.
    Comment on everything, explain why I use things.
    "Why am I using this composable function, what does it do?"

 */