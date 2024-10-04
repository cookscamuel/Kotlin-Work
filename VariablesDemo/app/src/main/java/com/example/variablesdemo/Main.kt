package com.example.variablesdemo

var name:String = "Samuel"
const val MAX_USERS = 100

fun main() {

    // print statement
    println("Hello Kotlin!\nThis should be fun!\nMy name is $name.")

    // val example
    val name2 = "George"
    // name2 = "Joe" // this would not work because name2 is val, not var.

    // var example
    var num = 33
    num = 103 // num can be reassigned because num is a var, not a val.

    // Explicitly specifying the type
    var name3 : String = "Kenneth"

    // Explicit val example
    val code : String = "Ghoulish"

    // printing every variable
    println("$name2 $num $name3 $MAX_USERS $code")

    while(num < 105) {
        num += 1
        println("$$num for $name2")
        if (num < 105) {
            println("Could use a bit more.")
        }
        else {
            println("That's enough!")
        }
    }

    var status = false // IntelliJ notices when variables never change, and tells you to change them to val if they are set as var
    if (status) {
        println("This is TRUE")
    }
    else {
        println("It is FALSE")
    }

    fun multiply(x: Int, y: Int): Int {
        return x * y
    }

    println(multiply(num, 2))

    fun writeMyName(name: String) {
        println(name)
    }

    writeMyName("George")

    fun displayResult(x: Int, y: Int): Unit {
        var ans = x * y
        println("Product of $x and $y is $ans")
    }

    displayResult(2, 5)
}