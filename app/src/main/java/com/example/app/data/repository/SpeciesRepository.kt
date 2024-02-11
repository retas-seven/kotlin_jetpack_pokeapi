package com.example.app.data.repository;

import com.example.app.data.repository.dto.SpeciesResultDto

interface SpeciesRepository {
    suspend fun searchSpecies(idOrName: String): SpeciesResultDto
}
