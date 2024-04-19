package com.example.app.presentation

sealed class ScreenRoute(val route: String) {
    object PokemonSearchScreen : ScreenRoute("pokemon_search_screen")
    object PokemonListScreen : ScreenRoute("pokemon_list_screen")
    object PokemonDetailScreen : ScreenRoute("pokemon_detail_screen")

}

