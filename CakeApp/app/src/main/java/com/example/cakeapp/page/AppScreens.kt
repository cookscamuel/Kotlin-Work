package com.example.cakeapp.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cakeapp.R

/*
    Author: Samuel Cook
    Date: October 18, 2024
    Project: Cake Ordering App
    Filename: NavItem.kt
    Purpose: File that holds composable functions for
             displaying pages and page elements.
 */

// this is a hard-coded array of cake descriptions.
// combined with the array beneath it, this can be
// used to display cake image and description combinations.

// I took this route rather than making a class to create cake objects
// as I thought it would be simpler and more in-line with this project.
val cakeDesc = arrayOf("Gumdrop Pound Cake: $5.99",
                       "Glazed Lemon Cake: $9.99",
                       "Cherry Delight: $11.99",
                       "Strawberry Dream: $11.99",
                       "16\" Forest Cake: $24.99",)

// This is the array of matching cake images.
val cakeImg = arrayOf(R.drawable.cake2,
    R.drawable.cake3, R.drawable.cake7,
    R.drawable.cake5, R.drawable.cake4)


// This function can be used to display any cake in the collection
// cakes by utilizing the global arrays.
@Composable
fun DisplayAllCakes(counter: Int, rotations: Int) {
    // counter is used to pinpoint the start position
    // when displaying the cakes.
    // rotations is used to determine the end position.
    // You can use this function to display all cakes,
    // or just one.

    var increment = counter
    // I had to do this because counter cannot change

    Column {
        while (increment < rotations) {

            Row {

                Text(

                    text = cakeDesc[increment],
                    color = Color.Black,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier.padding(25.dp)

                )

                Image(
                    modifier = Modifier
                        .size(80.dp),
                    painter = painterResource(id = cakeImg[increment]),
                    contentDescription = "A small cake clip-art."
                )
            }
            increment++
            // it basically will just loop the number of times
            // the user tells it to and will display a description
            // and a picture in a row.
        }
    }

}

// This is used to display the home page.
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    // Two columns, one for the outer border color, and one
    // for the main page background. They are also used to
    // format the arrangement of the page elements.
    // These columns are used in every composable.
    Column (modifier
        .fillMaxSize()
        .background(Color(0xFFe7a6ff))){
        Column(
            modifier
                .fillMaxSize()
                .padding(6.dp, 6.dp, 6.dp, 88.dp)
                .background(Color(0xFFffebfe)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Text displaying the title
            Text(
                text = "Baking Me\nCrazy!",
                Modifier.padding(8.dp),
                fontSize = 55.sp,
                color = Color(0xFF4599ff),
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Cursive,
                textAlign = TextAlign.Center,
                letterSpacing = 3.sp,
                lineHeight = 55.sp

            )

            // Image displayed as kind of a logo/decoration
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(210.dp),
                painter = painterResource(id = R.drawable.cake1),
                contentDescription = "A small cake clip-art."
            )

            //The rest of this function is just text for the home page.

            Text(
                text = "We're so glad you're here!",
                color = Color.Black,
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(8.dp)
            )

            Text(
                text = "Since 1987, we have had the very same mission that our founder," +
                        " Dr. T.J. Eckleburg, set out to achieve: bring delicious baked" +
                        " goods to the world. We are constantly striving to outdo ours" +
                        "elves and redefine flavour in the baking world. Visit our men" +
                        "u page to see the wide-variety of cakes we are proud to call " +
                        "ours!",
                color = Color.Black,
                fontSize = 20.sp,
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(25.dp)
            )

        }
    }
}

// This function displays the menu screen.
@Composable
fun MenuScreen(modifier: Modifier = Modifier) {
    // Once again, two columns for the background.
    Column (modifier
        .fillMaxSize()
        .background(Color(0xFFe7a6ff))){
        Column(
            modifier
                .fillMaxSize()
                .padding(6.dp, 6.dp, 6.dp, 88.dp)
                .background(Color(0xFFffebfe)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // This image is just for decoration
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(80.dp),
                painter = painterResource(id = R.drawable.cake6),
                contentDescription = "A small cake clip-art."
            )

            // Title for the page
            Text(
                text = "Fresh Cakes",
                modifier = Modifier.padding(8.dp, 0.dp, 8.dp, 0.dp),
                fontSize = 55.sp,
                color = Color(0xFF4599ff),
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Cursive,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                letterSpacing = 3.sp

            )

            // Decorative text
            Text(
                text = "All of our cakes are baked fresh in-house with natural ingredients.",
                color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(18.dp, 0.dp, 18.dp, 0.dp)
            )

            // simple spacer to add some space in between components
            Spacer(modifier = Modifier.height(20.dp))

            // this calls the function to display all available cakes,
            // the values are integers. I used the cakeDesc.size
            // to make sure I don't go too far and attempt to reach
            // indexes that do not exist.
            DisplayAllCakes(0, cakeDesc.size)

            // Extra decorative text.
            Text(
                text = "For a complete list of ingredients and nutrition facts, please visit our we" +
                        "bsite. Cake availability may vary.",
                color = Color.Black,
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Serif,
                lineHeight = 15.sp,
                modifier = Modifier.padding(16.dp, 25.dp, 16.dp, 0.dp)
            )

        }
    }
}

// Function that displays the ordering screen
@Composable
fun OrderScreen(modifier: Modifier = Modifier) {

    // variables used to keep track of the quantity entered by the user,
    // and also the quantity currently displayed on the screen.
    var quantity by remember { mutableStateOf("") }
    var displayQuantity by remember { mutableStateOf("") }

    // background columns
    Column (Modifier
        .fillMaxSize()
        .background(Color(0xFFe7a6ff))){
        Column(
            modifier
                .fillMaxSize()
                .padding(6.dp, 6.dp, 6.dp, 88.dp)
                .background(Color(0xFFffebfe)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // A row to arrange the title of the page
            Row(Modifier.padding(25.dp)) {

                // decorative cake image
                Image(
                    modifier = Modifier
                        .size(80.dp),
                    painter = painterResource(id = R.drawable.cake8),
                    contentDescription = "A small cake clip-art."
                )

                // Title for the page
                Text(
                    text = "Order",
                    Modifier.padding(8.dp, 0.dp, 8.dp, 0.dp),
                    fontSize = 55.sp,
                    color = Color(0xFF4599ff),
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.Cursive,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center,
                    letterSpacing = 3.sp
                )

                // The row places the cake next to the title
            }

            // Subtitle text
            Text(
                text = "Current Order:",
                color = Color.Black,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(18.dp, 0.dp, 18.dp, 0.dp)
            )

            // simple spacer for padding.
            Spacer(modifier = Modifier.height(15.dp))

            // DisplayAllCakes used to display a single cake/description combination.
            DisplayAllCakes(1, 2)

            // prompt the user to enter a quantity
            Text(
                text = "Please enter your desired quantity:",
                color = Color.Black,
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Serif,
                lineHeight = 15.sp,
                modifier = Modifier.padding(16.dp, 10.dp, 16.dp, 10.dp)
            )

            // textfield to allow for user input.
            OutlinedTextField(
                value = quantity,
                onValueChange = { quantity = it },
                label = { Text("quantity",
                    color = Color.Black,
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Center) },
                modifier = Modifier
                    .width(110.dp)
            )

            // button to submit the desired quantity.
            Button(onClick = {
                displayQuantity = calculateTotal(quantity)
                // this function calculates an appropriate message
                // for the user based on their input
            },
            Modifier.padding(20.dp)) {
                Text(text = "Place Order")
            }


            // this is used to display the results of
            // the user clicking the button.
            // by default, there is nothing displayed.
            Text(
                text = displayQuantity,
                color = Color.Black,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(16.dp, 5.dp, 16.dp, 0.dp)
            )

        }
    }
}

// This is a small function just to calculate the output
// message when the button is clicked.
// I was going to place it somewhere else, but because it
// is so small and minor, I decided to keep it here. If
// this was a larger function, or if I had more of these,
// I would have separated it from the composables in here.
fun calculateTotal(qty: String): String {

    // check if the user entered a non-integer value
    return if (qty.toIntOrNull() != null) {
        val subtotal = (qty.toInt() * 9.99).toString()
        "SUBTOTAL: $$subtotal\nORDER SUCCESSFULLY PLACED"

    } else {
        "ERROR: invalid quantity! (please enter an integer value)"
    }
    // this is a simple if statement that just updates the displayed
    // text every time the user clicks the button, depending on the
    // quantity that was entered.
}