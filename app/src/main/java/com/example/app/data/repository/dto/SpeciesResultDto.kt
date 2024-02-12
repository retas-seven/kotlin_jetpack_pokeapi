package com.example.app.data.repository.dto

import com.example.app.data.remote.auto_gen.species.Name

data class SpeciesResultDto(
    val id: Int,
    val baseHappiness: Int,
    val name: String,
    val type: String,
    val flavorTexts: List<String>,
    val officialArtworkUrl: String
)
