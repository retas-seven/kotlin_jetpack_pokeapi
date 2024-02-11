package com.example.app.presentation.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.common.StateNotice
import com.example.app.use_case.SpeciesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor (
    private val speciesUseCase: SpeciesUseCase
): ViewModel() {
    private var _name = mutableStateOf("---")

    init {
        println(">>>HomeScreenViewModel init")
    }

    fun searchSpecies(idOrName: String) {
        println(">>>searchSpecies start")
        viewModelScope.launch {
            val speciesResultDto = speciesUseCase.searchSpecies(idOrName)
            println(">>>species: $speciesResultDto")
            _name.value = speciesResultDto.name
        }
        println(">>>searchSpecies end")
    }

    fun searchSpeciesFlow(idOrName: String) {
        println(">>>searchSpeciesFlow start")
        speciesUseCase.searchSpeciesFlow(idOrName).onEach { stateNotice ->
            when (stateNotice) {
                is StateNotice.Loading -> {
                    println(">>>Loading")
                }
                is StateNotice.Success -> {
                    println(">>>Success: ${stateNotice.data}")
                    println(">>>data.name: ${stateNotice.data?.name ?: "none"}")
                    _name.value = stateNotice.data?.name ?: "none"
                }
                is StateNotice.Failure -> {
                    println(">>>Failure: ${stateNotice.error}")
                }
            }
        }.launchIn(viewModelScope)
        println(">>>searchSpeciesFlow end")
    }

    fun getName(): String {
        return _name.value
    }
}