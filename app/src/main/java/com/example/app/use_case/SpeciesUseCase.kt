package com.example.app.use_case

import com.example.app.common.StateNotice
import com.example.app.data.repository.dto.SpeciesResultDto
import kotlinx.coroutines.flow.Flow

interface SpeciesUseCase {
    suspend fun searchSpecies(idOrName: String): SpeciesResultDto
    fun searchSpeciesFlow(idOrName: String): Flow<StateNotice<SpeciesResultDto>>
}