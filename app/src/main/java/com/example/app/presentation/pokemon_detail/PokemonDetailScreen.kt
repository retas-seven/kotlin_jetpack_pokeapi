package com.example.app.presentation.pokemon_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import coil.compose.AsyncImage
import com.example.app.presentation.ScreenRoute

@Composable
fun PokemonDetailScreen(
    navController: NavController,
    viewModel: PokemonDetailScreenViewModel = hiltViewModel(),
) {
    println(">>>PokemonDetailScreen start")
    var isLoadingImage = remember { mutableStateOf(false) }

    Column {
        Button(
            onClick = {
                navController.navigate(ScreenRoute.PokemonSearchScreen.route)
            }
        ) {
            Text(text = "Back")
        }
        Button(
            onClick = {
                isLoadingImage.value = true
                viewModel.searchSpecies("25")
            }
        ) {
            Text(text = "Search Species")
        }
        Button(
            onClick = {
                isLoadingImage.value = true
                viewModel.searchSpeciesFlow("1")
            }
        ) {
            Text(text = "Search Species Flow")
        }
        Text(text = viewModel.getName())
        Text(text = viewModel.type)
        viewModel.flavorTexts.forEach {
            Text(text = it)
        }

        Box(modifier = Modifier.heightIn(min = 200.dp)) {
            if (isLoadingImage.value) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                )
            }
            AsyncImage(
                model = viewModel.officialArtworkUrl,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            topStartPercent = 0,
                            topEndPercent = 0,
                            bottomEndPercent = 5,
                            bottomStartPercent = 5,
                        )
                    ),
                onSuccess = { isLoadingImage.value = false },
            )
        }
    }
}
