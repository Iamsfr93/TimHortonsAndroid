# ☕ Tim Hortons Android App

A modern coffee ordering Android application built with **Kotlin** and **Jetpack Compose**.

This project was created as an Android development project to practice building a complete ordering flow, managing application state with a ViewModel, displaying product images, and creating a clean Compose-based user interface.

---

## 📱 Features

### ☕ Menu

- Displays a Tim Hortons-style coffee menu
- Coffee images for each product
- Coffee name and description
- Product pricing
- Add items to cart
- Displays the current cart item count

### 🛒 Shopping Cart

- View all selected products
- Display product images
- Increase item quantity
- Decrease item quantity
- Automatically remove an item when its quantity reaches zero
- Calculate total cart quantity
- Calculate total cart price
- Clear cart after placing an order

### 💳 Checkout

- Review the order before placing it
- Display total items
- Display order total
- Place an order
- Return to the cart

### ✅ Order Confirmation

- Displays an order confirmation screen
- Generates an order number
- Allows the customer to return to the menu

---

## 🛠️ Technologies Used

- **Kotlin**
- **Jetpack Compose**
- **Material 3**
- **Android SDK**
- **Android Studio**
- **ViewModel**
- **Compose State**
- **LazyColumn**
- **Cards**
- **Drawable Resources**

---

## 🏗️ Project Structure

```text
TimHortonsAndroid/
│
├── app/
│   └── src/
│       └── main/
│           ├── java/
│           │   └── com.example.timhortonsandroid/
│           │       │
│           │       ├── MainActivity.kt
│           │       │
│           │       ├── model/
│           │       │   ├── CartItem.kt
│           │       │   ├── Coffee.kt
│           │       │   └── CoffeeData.kt
│           │       │
│           │       ├── ui/
│           │       │   └── MenuScreen.kt
│           │       │
│           │       ├── ui/theme/
│           │       │   ├── CartScreen.kt
│           │       │   ├── CheckoutScreen.kt
│           │       │   ├── OrderConfirmationScreen.kt
│           │       │   ├── Color.kt
│           │       │   ├── Theme.kt
│           │       │   └── Type.kt
│           │       │
│           │       └── viewmodel/
│           │           └── CartViewModel.kt
│           │
│           └── res/
│               ├── drawable/
│               │   ├── dark_roast.png
│               │   ├── decaf_coffee.png
│               │   ├── french_vanilla.png
│               │   └── original_blend.png
│               │
│               └── ...
│
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
└── README.md
