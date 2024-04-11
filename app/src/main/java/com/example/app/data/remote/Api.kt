package com.example.app.data.remote

import com.example.app.data.remote.auto_gen.species.SpeciesResultData
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * APIをコールするクラス
 */
interface Api {

    /**
     * ポケモンの情報を取得する
     * https://pokeapi.co/api/v2/pokemon-species/1/
     */
    @GET("pokemon-species/{id}")
    suspend fun species(@Path("id") photoId: String): SpeciesResultData

    // icon
    //https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png
}
