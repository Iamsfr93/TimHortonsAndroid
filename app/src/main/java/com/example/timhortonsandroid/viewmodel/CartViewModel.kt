package com.example.timhortonsandroid.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.timhortonsandroid.model.CartItem
import com.example.timhortonsandroid.model.Coffee

// ViewModel stores and manages the cart
class CartViewModel : ViewModel() {

    private val _cartItems = mutableStateListOf<CartItem>()

    val cartItems: List<CartItem>
        get() = _cartItems

    // Add coffee to the cart
    fun addToCart(coffee: Coffee) {

        val existingItem = _cartItems.find {
            it.coffee.id == coffee.id
        }

        if (existingItem != null) {

            existingItem.quantity++

        } else {

            _cartItems.add(
                CartItem(
                    coffee = coffee,
                    quantity = 1
                )
            )
        }
    }

    // Get total number of items in the cart
    fun getCartItemCount(): Int {

        return _cartItems.sumOf {
            it.quantity
        }
    }

    // Increase quantity
    fun increaseQuantity(coffee: Coffee) {

        val existingItem = _cartItems.find {
            it.coffee.id == coffee.id
        }

        if (existingItem != null) {

            existingItem.quantity++
        }
    }

    // Decrease quantity or remove item
    fun decreaseQuantity(coffee: Coffee) {

        val existingItem = _cartItems.find {

            it.coffee.id == coffee.id

        }

        if (existingItem != null) {

            if (existingItem.quantity > 1) {

                existingItem.quantity--

            } else {

                _cartItems.remove(existingItem)

            }

        }

    }

// Calculate total price of all items in the cart

    fun getCartTotal(): Double {

        return _cartItems.sumOf { cartItem ->

            cartItem.coffee.price * cartItem.quantity

        }

    }
    // Calculate subtotal
    fun getSubtotal(): Double {

        return _cartItems.sumOf { cartItem ->

            cartItem.coffee.price * cartItem.quantity

        }
    }

    // Calculate tax
    fun getTax(): Double {

        return getSubtotal() * 0.13

    }
    fun clearCart() {

        _cartItems.clear()

    }
}