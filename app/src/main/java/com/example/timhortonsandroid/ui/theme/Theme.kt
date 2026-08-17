package com.example.timhortonsandroid.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Typography

private val TimHortonsColorScheme = lightColorScheme(

    primary = TimHortonsRed,

    secondary = TimHortonsDarkRed,

    background = TimHortonsCream,

    surface = TimHortonsWhite,

    onPrimary = TimHortonsWhite,

    onSecondary = TimHortonsWhite,

    onBackground = TimHortonsBrown,

    onSurface = TimHortonsBrown
)

@Composable
fun TimHortonsAndroidTheme(
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colorScheme = TimHortonsColorScheme,
        typography = Typography(),
        content = content
    )
}