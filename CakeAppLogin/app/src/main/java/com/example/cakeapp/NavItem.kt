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

// This is a data class that makes pairs of names and icons.
// Objects created from them are displayed as the clickable pieces
// in the nav bar. For example, Home + (picture of house) would
// be an object
data class NavItem (

    val name : String,
    val icon : ImageVector

)