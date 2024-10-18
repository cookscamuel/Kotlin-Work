package com.example.mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.*
import com.example.mvvm.ui.theme.MVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMTheme {
                val navController = rememberNavController()
                val mainViewModel: MainViewModel = viewModel()
                NavHost(navController = navController, startDestination = "welcome") {
                    composable("welcome") { WelcomeScreen(navController, MainViewModel()) }
                    composable("home") { HomeScreen(navController, MainViewModel()) }
                }
            }
        }
    }
}


// This is a ViewModel class. It is usually used to hold business logic that can be displayed in
// the UI. This might hold the logic on how to perform the calculations in a calculator app.
class MainViewModel : ViewModel() {
    var welcomeMessage: String = "Hello! Welcome to the App!"
    var homeMessage: String = "Hello! This is the home page!"
}

@Composable
fun WelcomeScreen(navController: NavHostController, mainViewModel: MainViewModel) {


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = mainViewModel.welcomeMessage, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navController.navigate("home") },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Go to Home Page")
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController, mainViewModel: MainViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = mainViewModel.homeMessage, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Go to Previous Page")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProject() {
    MVVMTheme {
        WelcomeScreen(navController = rememberNavController(), viewModel())
    }
}