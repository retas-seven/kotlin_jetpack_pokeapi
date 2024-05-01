package com.example.app.presentation.pokemon_search

import android.content.Context
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.app.R
import com.example.app.presentation.ScreenRoute
import com.example.app.util.AppUtil
import com.example.app.util.GIFImage
import timber.log.Timber
import androidx.compose.ui.viewinterop.AndroidView


/**
 * ポケモン検索画面
 */
@Composable
fun PokemonSearchScreen(
    navController: NavController,
    viewModel: PokemonSearchScreenViewModel = hiltViewModel(),
) {
    val inputValue = rememberSaveable { mutableStateOf("") }

    Column {
        Button(
            onClick = {
                navController.navigate(ScreenRoute.PokemonDetailScreen.route + "/1")
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
                    checkSearchResult(viewModel, inputValue.value, navController)
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
                            checkSearchResult(viewModel, it, navController)
                        }
                    ) {
                        Text(it)
                    }
                }
            }
        }
    }
}

/**
 * 検索結果をチェックし、遷移先を決定する
 */
fun checkSearchResult(viewModel: PokemonSearchScreenViewModel, inputText: String, navController: NavController) {
    Timber.d(">>>inputText: ${inputText}")
    val (count, pokemonIds) = viewModel.checkApplicablePokemonCount(AppUtil.convertHiraganaToKatakana(inputText))
    if (count == 1) {
        // 取得件数が１県の場合、詳細画面に遷移
        navController.navigate(ScreenRoute.PokemonDetailScreen.route + "/${pokemonIds[0]}")
    } else if (count > 1) {
        // 取得件数が複数件の場合、一覧画面に遷移
        val concatPokemonId = pokemonIds.joinToString(",")
        navController.navigate(ScreenRoute.PokemonListScreen.route + "/${concatPokemonId}")
    } else {
        // TODO: 取得件数が０件の場合
    }
}
