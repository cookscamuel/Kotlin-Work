package com.example.calaculator

/*
    Author: Samuel Cook
    Date: October 7, 2024
    Project: Integer Calculator Application
    Filename: MainActivity.kt
    Purpose: Allow for two integer values to be entered, and perform an operation of the user's choosing.
 */


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.calaculator.ui.theme.CalaculatorTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalaculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {

                    Calculator()
                    // This is where the Calculator function is called, allowing the program to run.

                }
            }
        }
    }
}

@Composable
fun Calculator() {

    // Variables
    var numOne by remember { mutableStateOf("") } // used to hold the first number the user enters.
    var numTwo by remember { mutableStateOf("") } // used to hold the second number the user enters.
    var answer by remember { mutableStateOf("") } // used to display the current answer/result of calculation.
    var userOp by remember { mutableStateOf("") } // used to keep track of what operation the user selected.

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(10.dp)
    ) {
    // a column that acts as the background for the app, it is used primarily to give
    // the app it's gray outline on the sides.

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(248, 248, 255))
                .padding(10.dp, 100.dp, 10.dp, 300.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
        // this column is used to hold all the components that need to be displayed, including
        // text boxes, buttons, and the answer.

            Text(text = answer,
                modifier = Modifier,
                fontSize = 25.sp,
                color = Color.Black,
                fontFamily = FontFamily.Serif,
                textAlign = TextAlign.Center
            )
            // this text function is used to display the result of the most recent calculation.
            // by default, it displays nothing.

            Spacer(modifier = Modifier
                .padding(30.dp)
            )
            // a simple spacer to add some space between the answer and the title.


            Text(
                text = "integer calculator",
                modifier = Modifier,
                fontSize = 35.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                textAlign = TextAlign.Center
            )
            // this text function is used to display the title.

            Row {
            // this row is used to keep the two text entry boxes aligned vertically.

                OutlinedTextField(
                    value = numOne,
                    onValueChange = { numOne = it },
                    label = { Text("enter an integer",
                        modifier = Modifier,
                        color = Color.Black,
                        fontFamily = FontFamily.Serif,
                        textAlign = TextAlign.Center) },
                    modifier = Modifier
                        .width(175.dp)
                        .padding(5.dp)
                )
                // this is the text box for the first integer the user can enter.

                OutlinedTextField(
                    value = numTwo,
                    onValueChange = { numTwo = it },
                    label = { Text("enter an integer",
                        modifier = Modifier,
                        color = Color.Black,
                        fontFamily = FontFamily.Serif,
                        textAlign = TextAlign.Center) },
                    modifier = Modifier
                        .width(175.dp)
                        .padding(5.dp)
                )
                // this is the text box for the second integer the user can enter.

            }
            // this is the closing tag for the text box row.

            Spacer(modifier = Modifier.height(10.dp))
            // another simple spacer to add some space in between components.

            Row {
            // this row is used to separate buttons in pairs of two, having a 2x2
            // end result for displaying them.

    ////////////////////////////////////// ADDITION BUTTON /////////////////////////////////////////////
                OutlinedButton( onClick =  {

                userOp = "1"
                answer = calculatorMath(numOne, numTwo, userOp)
                // set the user's chosen operator to "1", which corresponds to
                // addition.
                // The returned value is stored in the variable called "answer", which is
                // displayed as text on Line 66.

                },
                    modifier = Modifier
                        .width(170.dp)
                        .padding(4.dp)
                ) {
                    Text("Addition (+)",
                    color = Color(40, 191, 80))
                }
                // these are just used to style the button.

    ///////////////////////////////////// SUBTRACTION BUTTON ///////////////////////////////////////////
                OutlinedButton( onClick =  {

                userOp = "2"
                answer = calculatorMath(numOne, numTwo, userOp)
                // set the user's chosen operator to "2", which corresponds to
                // subtraction, and run the function calculatorMath.
                // The returned value is stored in the variable called "answer", which is
                // displayed as text on Line 66.

                },
                    modifier = Modifier
                        .width(170.dp)
                        .padding(4.dp)
                ) {
                    Text("Subtraction (-)",
                    color = Color(217, 60, 28))
                }
            }
            // again, these are just used to style the button.


            Row {
            // this is the second row that will hold the last two buttons.

    /////////////////////////////////// MULTIPLICATION BUTTON //////////////////////////////////////////
                OutlinedButton( onClick =  {

                userOp = "3"
                answer = calculatorMath(numOne, numTwo, userOp)
                // set the chosen operator to "3", which represents multiplication.
                // run the calculatorMath function.
                // The returned value is stored in the variable called "answer", which is
                // displayed as text on Line 66.

                },
                    modifier = Modifier
                        .width(170.dp)
                        .padding(4.dp)
                ) {
                    Text("Multiplication (×)",
                    color = Color(18, 164, 255))
                }
                // more button stylings.

    ////////////////////////////////////// DIVISION BUTTON /////////////////////////////////////////////
                OutlinedButton( onClick =  {

                    userOp = "4"
                    answer = calculatorMath(numOne, numTwo, userOp)
                    // set the chosen operator to "4" for division, then run
                    // the calculatorMath function.
                    // The returned value is stored in the variable called "answer", which is
                    // displayed as text on Line 66.

                },
                    modifier = Modifier
                        .width(170.dp)
                        .padding(4.dp)
                ) {
                    Text("Division (÷)",
                    color = Color(166, 20, 199))
                }
                // more button stylings.
            }
        }
    }
}

// function that handles all calculations, depending on which operation the user selects.
fun calculatorMath(num1: String, num2: String, type: String): String {

    if (num1.toIntOrNull() != null && num2.toIntOrNull() != null) {
    // this uses toIntOrNull() to see if both input fields are proper integer values.

        when (type) { // when statement, matching what the user selected to the correct operation.
            "1" -> {
                return "answer:\n$num1 + $num2 = " + (num1.toInt() + num2.toInt()).toString()
                // return the sum of the entered values (values become real integers with toInt()).
            }
            "2" -> {
                return "answer:\n$num1 - $num2 = " + (num1.toInt() - num2.toInt()).toString()
                // return the difference of the entered values (values become real integers with toInt()).
            }
            "3" -> {
                return "answer:\n$num1 × $num2 = " + (num1.toInt() * num2.toInt()).toString()
                // return the product of the entered values (values become real integers with toInt()).
            }
            else -> {
                return if (num2.toIntOrNull() == 0) { // this checks to see if the user is trying to divide by zero.
                    "ERROR:\ncannot divide by zero!" // this will return an error message if the user tries to divide by zero.
                } else {
                    "answer:\n$num1 ÷ $num2 = " + (num1.toInt() / num2.toInt()).toString()
                    // perform the division as per usual.
                }
            }
        }

    }
    else {
        return "ERROR:\ninvalid input!"
    }
    // if one or both of the fields contain non-integer values, print out an error for the user.

}

@Preview
@Composable
fun PreviewTextDemo() {
    CalaculatorTheme {
        Calculator()
    }
}
// basic preview function for the calculator.
