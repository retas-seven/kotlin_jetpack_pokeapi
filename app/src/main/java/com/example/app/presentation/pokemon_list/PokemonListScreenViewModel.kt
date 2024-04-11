package com.example.app.presentation.pokemon_list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.common.StateNotice
import com.example.app.use_case.SpeciesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class PokemonListScreenViewModel @Inject constructor (
    savedStateHandle: SavedStateHandle,
): ViewModel() {
    private var _pokemonIds = mutableListOf<String>()
    val pokemonIds: List<String> get() = _pokemonIds.toList()

    init {
        Timber.d(">>>PokemonListScreenViewModel init!!")

        // 渡されたパラメータを保持する
        val concatPokemonId = savedStateHandle.get<String>("concatPokemonId") ?: ""
        if (concatPokemonId.isNotEmpty()) {

            _pokemonIds = concatPokemonId.split(",").toMutableList()
        }
    }
}
