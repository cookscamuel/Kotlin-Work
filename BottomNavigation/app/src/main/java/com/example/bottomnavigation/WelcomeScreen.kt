package com.example.bottomnavigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.bottomnavigation.page.HomeScreen

@Composable
fun WelcomeScreen(modifier: Modifier=Modifier) {

    val navItemList = listOf(
        NavItem(name = "HomeScreen",Icons.Default.Home),
        NavItem(name = "Favourites",Icons.Default.Face),
        NavItem(name = "Woah!", Icons.Default.Star)
    )
    var selectedOption by remember { mutableIntStateOf(value = 0) }

    Scaffold(
        modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed {index, navItem ->
                    NavigationBarItem(
                        selected = selectedOption == index,
                        onClick = { selectedOption = index },
                        icon = {
                            Icon(imageVector = navItem.icon, contentDescription = "icon")
                        },
                        label = {
                            Text(text = navItem.name)
                        }
                    )
                }
            }
        }
    )
    { innerPadding ->
        DesignScreen(modifier = Modifier.padding(innerPadding), selectedOption)
    }
}


@Composable
fun DesignScreen(modifier: Modifier=Modifier,selectedOption:Int) {
    when(selectedOption) {
        0->HomeScreen()
    }
}