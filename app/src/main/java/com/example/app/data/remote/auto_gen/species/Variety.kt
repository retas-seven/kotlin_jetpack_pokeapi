package com.example.app.data.remote.auto_gen.species


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Variety(
    @Json(name = "is_default")
    val isDefault: Boolean?,
    val pokemon: Pokemon?
)