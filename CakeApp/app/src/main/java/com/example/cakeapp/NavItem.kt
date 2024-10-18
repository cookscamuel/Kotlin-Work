package com.example.cakeapp

import androidx.compose.ui.graphics.vector.ImageVector

/*
    Author: Samuel Cook
    Date: October 18, 2024
    Project: Cake Ordering App
    Filename: NavItem.kt
    Purpose: The data class to handle the
             different navigation icons
             that will appear on the nav bar.
 */

data class NavItem (

    val name : String,
    val icon : ImageVector

)