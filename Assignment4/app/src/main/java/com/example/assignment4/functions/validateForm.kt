package com.example.assignment4.functions

/*
    Author: Samuel Cook
    Date: October 29, 2024
    Project: Cake Ordering App
    Filename: validateForm.kt
    Purpose: Function that is used to validate the user's input before registration.
 */

// Function used to validate the user's account prior to creation.
fun validateForm(nameError: String, emailError: String, passwordError: String): Boolean {
    return nameError.isEmpty() && emailError.isEmpty() && passwordError.isEmpty()
}
// returns true if there are no errors, or false if there is at least one error.
// by default, there are 3 errors, they just do not display text. This is so
// the user cannot navigate immediately to the login screen.