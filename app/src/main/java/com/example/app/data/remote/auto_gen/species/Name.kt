package com.example.app.data.remote.auto_gen.species


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Name(
    val language: Language?,
    val name: String?
)