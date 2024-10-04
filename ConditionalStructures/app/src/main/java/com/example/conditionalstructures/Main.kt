package com.example.conditionalstructures

fun main() {

    val membershipLevel = "Gold"
    val purchaseAmount = 150.0

    /*
        This block of code defines two immutable values. One is membershipLevel, it is a string
        of characters. The other is purchaseAmount, it is a double with a value of 150.
     */

    val discount = when (membershipLevel) {
        "Silver" -> 0.05
        "Gold" -> 0.10
        "Platinum" -> 0.15
        else -> 0.0
    }

    /*
        This block of code will apply a value to the immutable variable called discount. It uses
        a conditional when statement, comparing the value of membershipLevel. In this instance,
        membershipLevel has a value of "Gold", meaning the variable discount will have a value
        of 0.1.
     */

    val finalDiscount = if (purchaseAmount > 100) {
        discount + 0.05
    } else {
        discount
    }

    /*
        This block of code features a conditional if statement. It checks to see if the
        immutable value of purchaseAmount is greater than 100. If it is true, the value of
        the discount variable will have 0.05 added to its current variable. If it is not true,
        the value of discount will not change.
     */

    val finalPrice = purchaseAmount * (1 - finalDiscount)

    /*
        This line declares a new variable called finalPrice. It has a value equal to the value of
        purchaseAmount multiplied by (1 minus the value of finalDiscount).
     */

    println("Membership Level: $membershipLevel")
    println("Original Purchase Amount: $$purchaseAmount")
    println("Discount Percentage: ${finalDiscount * 100}%")
    /*
        The line above multiplies the value of finalDiscount by 100. It uses it to display the
        proper discount percentage.
     */
    println("Final Price after Discount: $$finalPrice")
}