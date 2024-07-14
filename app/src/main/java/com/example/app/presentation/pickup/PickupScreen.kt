package com.example.app.presentation.pokemon_list

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.app.compose.card.PokemonCard

class PickupScreen {
    companion object {
        val MAIN_DIV = MainDiv()
        val CARD_DIV = CardDiv()
    }

    class MainDiv {
        val HEIGHT_WEIGHT = 0.5f
    }

    class CardDiv {
        val HEIGHT_WEIGHT = 0.5f
        val PADDING = 30.dp
        val ROW_MARGIN = 30.dp
    }
}

@Composable
fun PickupScreen(
    navController: NavController,
    viewModel: PickupScreenViewModel = hiltViewModel(),
) {
    Column (
        modifier = Modifier.fillMaxSize()
    ){
        // メイン部
        Row(
            modifier = Modifier
                .weight(PickupScreen.MAIN_DIV.HEIGHT_WEIGHT)
                .fillMaxWidth()
                .background(Color.White)
        ) {
            // ここに最初のRowのコンテンツを配置
        }

        // カード部
        Column(
            modifier = Modifier
                .weight(PickupScreen.CARD_DIV.HEIGHT_WEIGHT)
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(PickupScreen.CARD_DIV.PADDING)
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
//                  .border(1.dp, Color.Black),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                PokemonCard(no = 1)
                PokemonCard(no = 2)
                PokemonCard(no = 3)
                PokemonCard(no = 4)
                PokemonCard(no = 5)
                PokemonCard(no = 6)
            }

            Spacer(modifier = Modifier.height(PickupScreen.CARD_DIV.ROW_MARGIN))

            Row (
                modifier = Modifier
                    .fillMaxWidth(),
//                  .border(1.dp, Color.Black),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                PokemonCard(no = 1)
                PokemonCard(no = 2)
                PokemonCard(no = 3)
                PokemonCard(no = 4)
                PokemonCard(no = 5)
                PokemonCard(no = 6)
            }
        }
    }
}
