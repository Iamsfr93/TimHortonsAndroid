package com.example.timhortonsandroid.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OrderConfirmationScreen(
    customerName: String,
    orderType: String,
    paymentMethod: String,
    total: Double,
    orderNumber: Int,
    onBackToMenu: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "Order Confirmed!"
        )

        Text(
            text = "Thank you, $customerName!"
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(16.dp),

                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Text(
                    text = "Order #$orderNumber"
                )

                Text(
                    text = "Order Type: $orderType"
                )

                Text(
                    text = "Payment: $paymentMethod"
                )

                Text(
                    text = "Total: $${"%.2f".format(total)}"
                )
            }
        }

        Text(
            text = "Your order has been placed successfully."
        )

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