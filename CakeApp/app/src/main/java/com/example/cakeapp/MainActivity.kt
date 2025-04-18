package com.example.cakeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.cakeapp.ui.theme.CakeAppTheme

/*
    Author: Samuel Cook
    Date: October 18, 2024
    Project: Cake Ordering App
    Filename: MainActivity.kt
    Purpose: The main file for the cake app to run.
 */

class MainActivity : ComponentActivity() {
    private lateinit var dbHelper: DBHelper // This line ...
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dbHelper = DBHelper(this)
        setContent {
            CakeAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CakeAppNavigation()
                    // This simply calls the rest of the project.
                }
            }
        }
    }
}


