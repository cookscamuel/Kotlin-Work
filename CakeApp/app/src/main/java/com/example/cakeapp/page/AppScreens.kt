package com.example.cakeapp.page

import android.view.Menu
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cakeapp.CakeAppNavigation
import com.example.cakeapp.R

@Composable
fun DisplayAllCakes() {
    Row {

        Text(

            text = "Gumdrop Pound Cake: $5.99",
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
            painter = painterResource(id = R.drawable.cake2),
            contentDescription = "A small cake clip-art."
        )
    }

    Row {

        Text(
            text = "Glazed Lemon Cake: $9.99",
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
            painter = painterResource(id = R.drawable.cake3),
            contentDescription = "A small cake clip-art."
        )
    }

    Row {

        Text(
            text = "Cherry Delight: $11.99",
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
            painter = painterResource(id = R.drawable.cake7),
            contentDescription = "A small cake clip-art."
        )
    }

    Row {

        Text(
            text = "Strawberry Dream: $11.99",
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
            painter = painterResource(id = R.drawable.cake5),
            contentDescription = "A small cake clip-art."
        )
    }

    Row {

        Text(
            text = "16\" Forest Cake: $24.99",
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
            painter = painterResource(id = R.drawable.cake4),
            contentDescription = "A small cake clip-art."
        )
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    Column (modifier = Modifier
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
                modifier = Modifier.padding(8.dp),
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

//////////////////////////////////////// MENU SCREEN ////////////////////////////////////////

@Composable
fun MenuScreen(modifier: Modifier = Modifier) {
    Column (modifier = Modifier
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
                text = "All of our cakes are baked fresh in-house with natural ingr" +
                        "edients.",
                color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(18.dp, 0.dp, 18.dp, 0.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            DisplayAllCakes()

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

///////////////////////////////////////// ORDER SCREEN ////////////////////////////////////////


@Composable
fun OrderScreen(modifier: Modifier = Modifier) {

    var quantity by remember { mutableStateOf("") }
    var displayQuantity by remember { mutableStateOf("") }

    Column (modifier = Modifier
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

            Row {

            Image(
                modifier = Modifier
                    .size(80.dp),
                painter = painterResource(id = R.drawable.cake8),
                contentDescription = "A small cake clip-art."
            )

            Text(
                text = "Order",
                modifier = Modifier.padding(8.dp, 0.dp, 8.dp, 0.dp),
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

            Spacer(modifier = Modifier.height(20.dp))

            Row {


                    Text(
                        text = "Glazed Lemon Cake\n$9.99 each",
                        color = Color.Black,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Justify,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily.Serif,
                        modifier = Modifier.padding(18.dp)

                    )

                Image(
                    modifier = Modifier
                        .size(80.dp),
                    painter = painterResource(id = R.drawable.cake3),
                    contentDescription = "A small cake clip-art."
                )
            }

            Text(
                text = "Please enter your desired quantity:",
                color = Color.Black,
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Serif,
                lineHeight = 15.sp,
                modifier = Modifier.padding(16.dp, 25.dp, 16.dp, 0.dp)

            )

            OutlinedTextField(
                value = quantity,
                onValueChange = { quantity = it },
                label = { Text("quantity",
                    modifier = Modifier,
                    color = Color.Black,
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Center) },
                modifier = Modifier
                    .width(110.dp)
            )


            Button(onClick = {
            displayQuantity = CalculateTotal(quantity)




            }, modifier = Modifier.padding(20.dp)) {

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

fun CalculateTotal(qty: String): String {

    if (qty.toIntOrNull() != null) {
        val subtotal = (qty.toInt() * 9.99).toString()
        return "SUBTOTAL: $$subtotal\nORDER SUCCESSFULLY PLACED"

    } else {
        return "ERROR: invalid quantity! (please enter an integer value)"
    }
}




// DELETE THIS LATER
@Preview
@Composable
fun PreviewScreens() {
//    CakeAppNavigation()
    OrderScreen()
}