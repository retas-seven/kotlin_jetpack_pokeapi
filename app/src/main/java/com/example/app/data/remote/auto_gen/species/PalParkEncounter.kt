package com.example.app.data.remote.auto_gen.species


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PalParkEncounter(
    val area: Area?,
    @Json(name = "base_score")
    val baseScore: Int?,
    val rate: Int?
)