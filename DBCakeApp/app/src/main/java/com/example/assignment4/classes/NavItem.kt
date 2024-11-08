package com.example.assignment4.classes

import androidx.compose.ui.graphics.vector.ImageVector

/*
    Author: Samuel Cook
    Date: October 29, 2024
    Project: Cake Ordering App
    Filename: NavItem.kt
    Purpose: Data class to handle Icon/Title combinations for the nav bar clickable buttons.
    This is a returning class from the previous assignment.
 */

data class NavItem (

    val name : String,
    val icon : ImageVector

)