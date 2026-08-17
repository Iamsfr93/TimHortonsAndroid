package com.example.timhortonsandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.timhortonsandroid.ui.CartScreen
import com.example.timhortonsandroid.ui.CheckoutScreen
import com.example.timhortonsandroid.ui.MenuScreen
import com.example.timhortonsandroid.ui.OrderConfirmationScreen
import com.example.timhortonsandroid.ui.theme.TimHortonsAndroidTheme
import com.example.timhortonsandroid.viewmodel.CartViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            TimHortonsAndroidTheme {

                val cartViewModel = remember {
                    CartViewModel()
                }

                var currentScreen by remember {
                    mutableStateOf("menu")
                }

                var customerName by remember {
                    mutableStateOf("")
                }

                var orderType by remember {
                    mutableStateOf("")
                }

                var paymentMethod by remember {
                    mutableStateOf("")
                }

                var orderTotal by remember {
                    mutableStateOf(0.0)
                }

                var orderNumber by remember {
                    mutableStateOf(0)
                }

                when (currentScreen) {

                    // MENU
                    "menu" -> {

                        MenuScreen(
                            cartViewModel = cartViewModel,

                            onCartClick = {
                                currentScreen = "cart"
                            }
                        )
                    }

                    // CART
                    "cart" -> {

                        CartScreen(
                            cartViewModel = cartViewModel,

                            onBackToMenu = {
                                currentScreen = "menu"
                            },

                            onCheckoutClick = {
                                currentScreen = "checkout"
                            }
                        )
                    }

                    // CHECKOUT
                    "checkout" -> {

                        CheckoutScreen(
                            cartViewModel = cartViewModel,

                            onOrderPlaced = {

                                // Save order information
                                orderTotal =
                                    cartViewModel.getSubtotal() +
                                            cartViewModel.getTax()

                                // Temporary order number
                                orderNumber =
                                    (10000..99999).random()

                                // Move to confirmation
                                cartViewModel.clearCart()

                                currentScreen = "confirmation"
                            },

                            onBackToCart = {
                                currentScreen = "cart"
                            }
                        )
                    }

                    // ORDER CONFIRMATION
                    "confirmation" -> {

                        OrderConfirmationScreen(
                            customerName = customerName,
                            orderType = orderType,
                            paymentMethod = paymentMethod,
                            total = orderTotal,
                            orderNumber = orderNumber,

                            onBackToMenu = {
                                currentScreen = "menu"
                            }
                        )
                    }
                }
            }
        }
    }
}