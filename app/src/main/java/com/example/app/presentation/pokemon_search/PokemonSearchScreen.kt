package com.example.app.presentation.pokemon_search

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.app.presentation.ScreenRoute
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.input.TextFieldValue
import com.example.app.util.AppUtil

@Composable
fun PokemonSearchScreen(
    navController: NavController,
    viewModel: PokemonSearchScreenViewModel = hiltViewModel(),
) {
    val inputValue = rememberSaveable { mutableStateOf("") }

    Column {
        Button(
            onClick = {
                navController.navigate(ScreenRoute.PokemonDetailScreen.route)
            }
        ) {
            Text(text = "Search Species")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            TextField(
                value = inputValue.value,
                onValueChange = { inputValue.value = it },
                label = { Text(text = "ポケモンのIDまたは名前") },
                modifier = Modifier.padding(16.dp)
            )
            IconButton(
                onClick = {
                    val (count, ids) = viewModel.checkApplicablePokemonCount(AppUtil.convertHiraganaToKatakana(inputValue.value))
                    if (count == 1) {
                        // 取得件数が１県の場合、詳細画面に遷移
                        navController.navigate(ScreenRoute.PokemonDetailScreen.route + "/${ids[0]}")
                    } else if (count > 1) {
                        // 取得件数が複数件の場合、一覧画面に遷移
                        navController.navigate(ScreenRoute.PokemonListScreen.route)
                    }
                }
            ) {
                Icon(Icons.Default.Search, contentDescription = "Search")
            }
        }

        // ボタンを表示する
        val allKatakanaRows = listOf(
            listOf("ア", "イ", "ウ", "エ", "オ"),
            listOf("カ", "キ", "ク", "ケ", "コ"),
            listOf("サ", "シ", "ス", "セ", "ソ"),
            listOf("タ", "チ", "ツ", "テ", "ト"),
            listOf("ナ", "ニ", "ヌ", "ネ", "ノ"),
            listOf("ハ", "ヒ", "フ", "ヘ", "ホ"),
            listOf("マ", "ミ", "ム", "メ", "モ"),
            listOf("ヤ", "ユ", "ヨ"),
            listOf("ラ", "リ", "ル", "レ", "ロ"),
            listOf("ワ", "ヲ", "ン")
        )
        allKatakanaRows.forEach { katakanaRow ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                katakanaRow.forEach {
                    TextButton(
                        onClick = {
                            val (count, ids) = viewModel.checkApplicablePokemonCount(it)
                            if (count == 1) {
                                // 取得件数が１県の場合、詳細画面に遷移
                                navController.navigate(ScreenRoute.PokemonDetailScreen.route + "/${ids[0]}")
                            } else if (count > 1) {
                                // 取得件数が複数件の場合、一覧画面に遷移
                                navController.navigate(ScreenRoute.PokemonListScreen.route)
                            }
                        }
                    ) {
                        Text(it)
                    }
                }
            }
        }
    }
}
