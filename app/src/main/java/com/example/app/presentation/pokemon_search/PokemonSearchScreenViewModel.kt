package com.example.app.presentation.pokemon_search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.common.StateNotice
import com.example.app.common.enum.PokemonNames
import com.example.app.use_case.SpeciesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class PokemonSearchScreenViewModel @Inject constructor (
    private val speciesUseCase: SpeciesUseCase
): ViewModel() {

    /**
     * 該当件数チェック
     */
    fun checkApplicablePokemonCount(inputStr: String): Pair<Int, MutableList<Int>> {
        Timber.d(">>>checkApplicablePokemonCount start: ${inputStr}")
        val pokemonIds : MutableList<Int> = mutableListOf()

        PokemonNames.values().forEach { enum ->
            if (enum.jp.startsWith(inputStr)) {
                pokemonIds.add(enum.id)
            }
        }

        Timber.d(">>>${pokemonIds}")
        return Pair(pokemonIds.size, pokemonIds)
    }
}