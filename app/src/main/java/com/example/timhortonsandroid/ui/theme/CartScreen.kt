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
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.timhortonsandroid.viewmodel.CartViewModel

@Composable
fun CartScreen(
    cartViewModel: CartViewModel,
    onBackToMenu: () -> Unit,
    onCheckoutClick: () -> Unit
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        // Cart title
        item {

            Text(
                text = "Your Cart"
            )
        }

        // Cart items
        items(cartViewModel.cartItems) { cartItem ->

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

                    // Coffee image
                    Image(
                        painter = painterResource(
                            id = cartItem.coffee.image
                        ),

                        contentDescription = cartItem.coffee.name,

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp),

                        contentScale = ContentScale.Crop
                    )

                    // Coffee name
                    Text(
                        text = cartItem.coffee.name
                    )

                    // Price
                    Text(
                        text = "$${"%.2f".format(cartItem.coffee.price)}"
                    )

                    // Quantity controls
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {

                        Button(
                            onClick = {

                                cartViewModel.decreaseQuantity(
                                    cartItem.coffee
                                )

                            }
                        ) {

                            Text("-")
                        }

                        Text(
                            text = "${cartItem.quantity}"
                        )

                        Button(
                            onClick = {

                                cartViewModel.increaseQuantity(
                                    cartItem.coffee
                                )

                            }
                        ) {

                            Text("+")
                        }
                    }
                }
            }
        }

        // Order summary
        item {

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "Order Summary"
            )

            Text(
                text = "Subtotal: $${"%.2f".format(
                    cartViewModel.getSubtotal()
                )}"
            )

            Text(
                text = "Tax: $${"%.2f".format(
                    cartViewModel.getTax()
                )}"
            )

            Text(
                text = "Total: $${"%.2f".format(
                    cartViewModel.getSubtotal() +
                            cartViewModel.getTax()
                )}"
            )
        }

        // Checkout button
        item {

            Button(
                onClick = onCheckoutClick,

                enabled = cartViewModel.cartItems.isNotEmpty(),

                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = "Checkout"
                )
            }
        }

        // Back to menu
        item {

            Button(
                onClick = onBackToMenu,

                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = "Back to Menu"
                )
            }
        }
    }
}