package com.example.app.presentation.pokemon_detail

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
class PokemonDetailScreenViewModel @Inject constructor (
    private val speciesUseCase: SpeciesUseCase,
    savedStateHandle: SavedStateHandle,
): ViewModel() {
    private var _name = mutableStateOf("---")
    var type = "---"
    var flavorTexts = listOf("---")
    var officialArtworkUrl = ""
//    var pokemonId = 0

    init {
        Timber.d(">>>HomeScreenViewModel init!!")

        // 渡されたパラメータを保持する
        savedStateHandle.get<String>("pokemonId")?.let { pokemonId ->
//            this.pokemonId = it
//            pokemonId.toIntOrNull()?.let {
//                searchSpeciesFlow(it)
//            }
            searchSpeciesFlow(pokemonId)
        }
//        Timber.d(">>>pokemonId: ${pokemonId}")
    }

    fun searchSpecies(idOrName: String) {
        Timber.d(">>>searchSpecies start")

        viewModelScope.launch {
            val speciesResultDto = speciesUseCase.searchSpecies(idOrName)
            Timber.d(">>>species: $speciesResultDto")

            _name.value = speciesResultDto.name
            type = speciesResultDto.type
            flavorTexts = speciesResultDto.flavorTexts
            officialArtworkUrl = speciesResultDto.officialArtworkUrl
        }

        Timber.d(">>>searchSpecies end")
    }

    fun searchSpeciesFlow(idOrName: String) {
        Timber.d(">>>searchSpeciesFlow start")

        speciesUseCase.searchSpeciesFlow(idOrName).onEach { stateNotice ->
            when (stateNotice) {
                is StateNotice.Loading -> {
                    Timber.d(">>>Loading")
                }

                is StateNotice.Success -> {
                    Timber.d(">>>Success: ${stateNotice.data}")
                    Timber.d(">>>data.name: ${stateNotice.data?.name ?: "none"}")
                    _name.value = stateNotice.data?.name ?: "none"
                    type = stateNotice.data?.type ?: "none"
                    flavorTexts = stateNotice.data?.flavorTexts ?: listOf("---")
                    officialArtworkUrl = stateNotice.data?.officialArtworkUrl ?: ""
                }

                is StateNotice.Failure -> {
                    Timber.d(">>>Failure: ${stateNotice.error}")
                }
            }
        }.launchIn(viewModelScope)

        Timber.d(">>>searchSpeciesFlow end")
    }

    fun getName(): String {
        return _name.value
    }
}