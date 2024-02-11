package com.example.app.data.remote

import com.example.app.data.remote.auto_gen.species.SpeciesResultData
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * APIをコールするクラス
 */
interface Api {
    @GET("pokemon-species/{id}")
    suspend fun species(@Path("id") photoId: String): SpeciesResultData
}
