package com.example.app.presentation

sealed class ScreenRoute(val route: String) {
    object HomeScreen : ScreenRoute("home_screen")
}

