package com.example.app.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel = hiltViewModel(),
) {
    println(">>>HomeScreen start")
    LaunchedEffect(key1 = Unit) {
        println(">>>HomeScreen LaunchedEffect")
    }

    Column {
        Button(
            onClick = { viewModel.searchSpecies("25") }
        ) {
            Text(text = "Search Species")
        }
        Button(
            onClick = { viewModel.searchSpeciesFlow("1") }
        ) {
            Text(text = "Search Species Flow")
        }
        Text(text = viewModel.getName())
    }
}
