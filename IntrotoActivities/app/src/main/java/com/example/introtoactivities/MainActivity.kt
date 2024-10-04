package com.example.introtoactivities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.introtoactivities.ui.theme.IntroToActivitiesTheme

class MainActivity : ComponentActivity() {
    // This is the main function.
    // inherits from ComponentActivity().

    override fun onCreate(savedInstanceState: Bundle?) {
        // refers to function from parent class

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // makes the activity responsive to mobile devices, I think?

        setContent {
            IntroToActivitiesTheme {
            // The general styles that apply to the entire application, across activities I think.
            // Inside this theme is where you can build the UI.
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                    // user defined function with "Android" being passed to it as an argument for name.
                }
            }
        }
    }
}

@Composable
// Composable lets you easily write down the components for UI as text.
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IntroToActivitiesTheme {
        Greeting("Android")
    }
}
// This is a preview function. It lets you see a preview of the entire program without
// needing a device or emulator.