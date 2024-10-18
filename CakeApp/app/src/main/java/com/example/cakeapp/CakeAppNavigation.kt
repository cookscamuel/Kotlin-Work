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

@Composable
fun CakeAppNavigation(modifier: Modifier=Modifier) {

    val navItemList = listOf(
        NavItem(name = "Home",Icons.Default.Home),
        NavItem(name = "Cakes",Icons.Default.Menu),
        NavItem(name = "Order", Icons.Default.ShoppingCart)
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
        1->MenuScreen()
        2-> OrderScreen()
    }
}