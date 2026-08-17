package com.example.timhortonsandroid.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.timhortonsandroid.viewmodel.CartViewModel

@Composable
fun CheckoutScreen(
    cartViewModel: CartViewModel,
    onOrderPlaced: () -> Unit,
    onBackToCart: () -> Unit
) {

    var customerName by remember {
        mutableStateOf("")
    }

    var orderType by remember {
        mutableStateOf("Pickup")
    }

    var paymentMethod by remember {
        mutableStateOf("Card")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "Checkout"
        )

        OutlinedTextField(
            value = customerName,

            onValueChange = {
                customerName = it
            },

            label = {
                Text("Customer Name")
            },

            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "Order Type"
        )

        RowOption(
            text = "Pickup",
            selected = orderType == "Pickup",
            onClick = {
                orderType = "Pickup"
            }
        )

        RowOption(
            text = "Dine-in",
            selected = orderType == "Dine-in",
            onClick = {
                orderType = "Dine-in"
            }
        )

        Text(
            text = "Payment Method"
        )

        RowOption(
            text = "Card",
            selected = paymentMethod == "Card",
            onClick = {
                paymentMethod = "Card"
            }
        )

        RowOption(
            text = "Cash",
            selected = paymentMethod == "Cash",
            onClick = {
                paymentMethod = "Cash"
            }
        )

        Text(
            text = "Items: ${cartViewModel.getCartItemCount()}"
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

        Button(
            onClick = onOrderPlaced,

            enabled = customerName.isNotBlank(),

            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "Place Order"
            )
        }

        Button(
            onClick = onBackToCart,

            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "Back to Cart"
            )
        }
    }
}

@Composable
private fun RowOption(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Row {

        RadioButton(
            selected = selected,
            onClick = onClick
        )

        Text(
            text = text
        )
    }
}