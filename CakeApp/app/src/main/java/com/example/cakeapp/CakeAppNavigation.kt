package com.example.cakeapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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
import com.example.cakeapp.page.HomeScreen
import com.example.cakeapp.page.MenuScreen
import com.example.cakeapp.page.OrderScreen

/*
    Author: Samuel Cook
    Date: October 18, 2024
    Project: Cake Ordering App
    Filename: CakeAppNavigation.kt
    Purpose: File that handles navigating between pages.
 */


@Composable
fun CakeAppNavigation(modifier: Modifier=Modifier) {

    val navItemList = listOf(
        NavItem(name = "Home",Icons.Default.Home),
        NavItem(name = "Cakes",Icons.Default.Menu),
        NavItem(name = "Order", Icons.Default.ShoppingCart)
    )
    var selectedOption by remember { mutableIntStateOf(value = 0) }
    // keep track of what the current selected option is. It will be
    // used to represent what page the user is on in the nav bar

    Scaffold(
        modifier.fillMaxSize(),
        // create a nav bar at the bottom of the screen, and
        // make three options the user can select based on the
        // list of nav items above.

        // this will not navigate the user, but it will represent which
        // option the user has most recently selected.
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
        SelectScreen(modifier = Modifier.padding(innerPadding), selectedOption)
        // call the function to actually navigate the user.
    }
}


// This will redirect the user to a specific page based on which option they selected.
@Composable
fun SelectScreen(modifier: Modifier=Modifier,selectedOption:Int) {
    when(selectedOption) {
        0->HomeScreen()
        1->MenuScreen()
        2->OrderScreen()
    }
}

/*
    I chose a nav bar because I felt it is extremely common
    in mobile apps today. It's also extremely easy to use,
    especially with one finger or thumb. On top of this, I
    really like the design and simplicity of a static bar at
    the bottom that doesn't disappear. The user should have
    a difficult time getting lost in this app.
 */