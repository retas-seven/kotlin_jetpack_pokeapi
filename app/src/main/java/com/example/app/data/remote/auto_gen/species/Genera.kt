package com.example.app.data.remote.auto_gen.species


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Genera(
    val genus: String?,
    val language: Language?
)