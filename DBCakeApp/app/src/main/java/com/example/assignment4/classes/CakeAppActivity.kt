package com.example.assignment4.classes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.assignment4.composables.CakeAppNavigation
import com.example.assignment4.ui.theme.Assignment4Theme

/*
    Author: Samuel Cook
    Date: October 29, 2024
    Project: Cake Ordering App
    Filename: CakeAppActivity.kt
    Purpose: Class that launches the composable functions/navigation bar segment.
    This is a returning class from the previous assignment.
 */

// Class that simply calls the main cake application and its screens/nav bar.
class CakeAppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment4Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Call the composable function that handles the main part of the cake app and navigation bar.
                    CakeAppNavigation()
                }
            }
        }
    }
}