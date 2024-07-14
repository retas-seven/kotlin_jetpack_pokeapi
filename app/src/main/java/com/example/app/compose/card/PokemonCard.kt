package com.example.app.compose.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class PokemonCard {
    companion object {
        @Stable
        val MAIN_DIV = MainDiv()
    }

    class MainDiv {
        val WIDTH = 120.dp
        val HEIGHT = 120.dp
    }
}

@Composable
fun PokemonCard(
    no: Int = 1,
) {
    Column (
        modifier = Modifier
            .width(PokemonCard.MAIN_DIV.WIDTH)
            .height(PokemonCard.MAIN_DIV.HEIGHT)
            .background(Color.White)
    ) {
        Text("No.$no")
    }
}

@Composable
@Preview
fun PokemonCardPreview() {
    PokemonCard()
}
