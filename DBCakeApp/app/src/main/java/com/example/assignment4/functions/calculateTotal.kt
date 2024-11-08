package com.example.assignment4.functions

/*
    Author: Samuel Cook
    Date: October 29, 2024
    Project: Cake Ordering App
    Filename: calculateTotal.kt
    Purpose: Function that is used to calculate and display the results of placing an order.
    This is a returning function from the previous assignment.
 */

fun calculateTotal(qty: String): String {

    return if (qty.toIntOrNull() != null) {
        val subtotal = (qty.toInt() * 9.99).toString()
        "SUBTOTAL: $$subtotal\nORDER SUCCESSFULLY PLACED"

    } else {
        "ERROR: invalid quantity! (please enter an integer value)"
    }
}