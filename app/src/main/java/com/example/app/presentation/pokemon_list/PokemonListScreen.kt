package com.example.app.presentation.pokemon_list

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun PokemonListScreen(
    navController: NavController,
    viewModel: PokemonListScreenViewModel = hiltViewModel(),
) {
    Column (
        modifier = Modifier.fillMaxSize()
    ){
        println(">>>PokemonListScreen start")
        Text(text = viewModel.pokemonIds.toString())

        val names = (1..500).map { "モケラ $it 号" }
        LazyColumn(
            modifier = Modifier
                .border(width = 1.dp, color = Color.Red)
                .fillMaxSize()
        ) {
            items(
                items = viewModel.pokemonIds,
                key = { it }
            ) { name ->
                Text(text = name)
            }
        }
    }
}
