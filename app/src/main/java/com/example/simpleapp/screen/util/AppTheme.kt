package com.example.simpleapp.screen.util

import androidx.compose.ui.graphics.Color

data class AppTheme(val name: String, val colors: List<Color>)

val themes = listOf(
    AppTheme("Purple", listOf(Color(0xFF343060), Color(0xFF482E5B))),
    AppTheme("Blue", listOf(Color(0xFF2193b0), Color(0xFF6dd5ed))),
    AppTheme("Sunset", listOf(Color(0xFFee9ca7), Color(0xFFffdde1))),
    AppTheme("Green", listOf(Color(0xFF56ab2f), Color(0xFFa8e063)))
)
