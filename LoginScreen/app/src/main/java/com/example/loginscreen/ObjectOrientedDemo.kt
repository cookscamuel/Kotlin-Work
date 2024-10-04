package com.example.loginscreen


class ObjectOrientedDemo (val title : String, val duration : Int) {
// this is the primary constructor, it is stored in the class header.
// it's like making the private variables in java.
// it is nothing like the constructor in java, it is only for
// making variables.

    constructor(title : String) : this(title, 60) { // this has a default parameter for duration
        println("Created lesson '$title' with default duration of 60 minutes.")
    }
    // this is the secondary constructor. 60 is automatically filled in if the
    // user does not specify duration.
    // this is like the constructor in java.

    fun displayLessonDetails() {
        println("Lesson Title: $title")
        println("Duration: $duration minutes.")
    }
    // function that is stored inside the class.
}

fun main() {

    val lesson1 = ObjectOrientedDemo("Kotlin Basics", 90)
    // this is what it looks like to make a new object with a class
    lesson1.displayLessonDetails()
    // it's like java when calling functions (not called methods here).

    println()

    val lesson2 = ObjectOrientedDemo("Advanced Kotlin")
    lesson2.displayLessonDetails()


    // you can create objects using the default constructor, and it works like java,
    // but you can also make secondary constructors that have automatic default values
    // and they work the same way, but they can make additional things, like print
    // statements, happen.

}