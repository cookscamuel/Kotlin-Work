package com.example.cakeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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

/*
    Author: Samuel Cook
    Date: October 18, 2024
    Project: Cake Ordering App
    Filename: AppScreens.kt
    Purpose: This is a massive file that contains
             every composable function pertaining
             to this project. This contains the
             home, menu, and order screens, and
             also the function for displaying the
             static navigation bar in the app
             along with logic to navigate the
             user.
 */

// Global arrays to allow composable functions to
// easily access images or descriptions from
// anywhere.

val cakeDesc = arrayOf("Gumdrop Pound Cake: $5.99",
                       "Glazed Lemon Cake: $9.99",
                       "Cherry Delight: $11.99",
                       "Strawberry Dream: $11.99",
                       "16\" Forest Cake: $24.99",)


val cakeImg = arrayOf(R.drawable.cake2,
    R.drawable.cake3, R.drawable.cake7,
    R.drawable.cake5, R.drawable.cake4)


// This function can be used to display any cake in the collection
// cakes by utilizing the global arrays.
@Composable
fun DisplayAllCakes(counter: Int, rotations: Int) {


    var increment = counter

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

        }
    }

}

// Function to display the landing page/home screen.
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
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

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(210.dp),
                painter = painterResource(id = R.drawable.cake1),
                contentDescription = "A small cake clip-art."
            )


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

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(80.dp),
                painter = painterResource(id = R.drawable.cake6),
                contentDescription = "A small cake clip-art."
            )

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

            Text(
                text = "All of our cakes are baked fresh in-house with natural ingredients.",
                color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(18.dp, 0.dp, 18.dp, 0.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            DisplayAllCakes(0, cakeDesc.size)


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

    var quantity by remember { mutableStateOf("") }
    var displayQuantity by remember { mutableStateOf("") }

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

            Row(Modifier.padding(25.dp)) {

                Image(
                    modifier = Modifier
                        .size(80.dp),
                    painter = painterResource(id = R.drawable.cake8),
                    contentDescription = "A small cake clip-art."
                )

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

            }

            Text(
                text = "Current Order:",
                color = Color.Black,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(18.dp, 0.dp, 18.dp, 0.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))

            DisplayAllCakes(1, 2)

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

            Button(onClick = {
                displayQuantity = calculateTotal(quantity)

            },
            Modifier.padding(20.dp)) {
                Text(text = "Place Order")
            }

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

// Function that handles the creation of the static navigation bar within the app.
@Composable
fun CakeAppNavigation(modifier: Modifier=Modifier) {

    val navItemList = listOf(
        NavItem(name = "Home", Icons.Default.Home),
        NavItem(name = "Cakes", Icons.Default.Menu),
        NavItem(name = "Order", Icons.Default.ShoppingCart)
    )
    var selectedOption by remember { mutableIntStateOf(value = 0) }

    Scaffold(
        modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed {index, navItem ->
                    NavigationBarItem(
                        selected = selectedOption == index,
                        onClick = { selectedOption = index },
                        icon = {
                            Icon(imageVector = navItem.icon, contentDescription = "icon")
                        },
                        label = {
                            Text(text = navItem.name)
                        }
                    )
                }
            }
        }
    )
    { innerPadding ->
        SelectScreen(modifier = Modifier.padding(innerPadding), selectedOption)
    }
}


// This will redirect the user to a specific page based on which option they selected.
@Composable
fun SelectScreen(modifier: Modifier=Modifier,selectedOption:Int) {
    when(selectedOption) {
        0-> HomeScreen()
        1-> MenuScreen()
        2-> OrderScreen()
    }
}
