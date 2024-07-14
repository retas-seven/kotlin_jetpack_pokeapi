package com.example.app.presentation

sealed class ScreenRoute(val route: String) {
    object MyTest : ScreenRoute("mytest_screen")
    object PickupSearchScreen : ScreenRoute("pickup_screen")
    object PokemonSearchScreen : ScreenRoute("pokemon_search_screen")
    object PokemonListScreen : ScreenRoute("pokemon_list_screen")
    object PokemonDetailScreen : ScreenRoute("pokemon_detail_screen")
}

