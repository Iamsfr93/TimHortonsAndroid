package com.example.timhortonsandroid.model

import com.example.timhortonsandroid.R

val coffeeMenu = listOf(

    Coffee(
        id = 1,
        name = "Original Blend",
        description = "Our classic Tim Hortons coffee.",
        price = 2.49,
        category = "Coffee",
        image = R.drawable.original_blend
    ),

    Coffee(
        id = 2,
        name = "Dark Roast",
        description = "A rich and bold dark roast coffee.",
        price = 2.49,
        category = "Coffee",
        image = R.drawable.dark_roast
    ),

    Coffee(
        id = 3,
        name = "Decaf Coffee",
        description = "Classic coffee without the caffeine.",
        price = 2.49,
        category = "Coffee",
        image = R.drawable.decaf_coffee
    ),

    Coffee(
        id = 4,
        name = "French Vanilla",
        description = "Smooth coffee with a sweet vanilla flavour.",
        price = 2.99,
        category = "Specialty",
        image = R.drawable.french_vanilla
    )
)