package com.example.timhortonsandroid.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.timhortonsandroid.model.coffeeMenu
import com.example.timhortonsandroid.viewmodel.CartViewModel

@Composable
fun MenuScreen(
    cartViewModel: CartViewModel,
    onCartClick: () -> Unit
) {

    var selectedCategory by remember {
        mutableStateOf("All")
    }

    val filteredCoffee = if (selectedCategory == "All") {

        coffeeMenu

    } else {

        coffeeMenu.filter {
            it.category == selectedCategory
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        // Screen title
        item {

            Text(
                text = "Tim Hortons Menu"
            )
        }

        // Category buttons
        item {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Button(
                    onClick = {
                        selectedCategory = "All"
                    }
                ) {

                    Text("All")
                }

                Button(
                    onClick = {
                        selectedCategory = "Coffee"
                    }
                ) {

                    Text("Coffee")
                }

                Button(
                    onClick = {
                        selectedCategory = "Specialty"
                    }
                ) {

                    Text("Specialty")
                }
            }
        }

        // View cart button
        item {

            Button(
                onClick = onCartClick
            ) {

                Text(
                    text = "View Cart (${cartViewModel.getCartItemCount()})"
                )
            }
        }

        // Coffee menu
        items(filteredCoffee) { coffee ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),

                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    Image(
                        painter = painterResource(
                            id = coffee.image
                        ),

                        contentDescription = coffee.name,

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp),

                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = coffee.name
                    )

                    Text(
                        text = coffee.description
                    )

                    Text(
                        text = "$${"%.2f".format(coffee.price)}"
                    )

                    Spacer(
                        modifier = Modifier.height(4.dp)
                    )

                    Button(
                        onClick = {
                            cartViewModel.addToCart(coffee)
                        }
                    ) {

                        Text(
                            text = "Add to Cart"
                        )
                    }
                }
            }
        }
    }
}