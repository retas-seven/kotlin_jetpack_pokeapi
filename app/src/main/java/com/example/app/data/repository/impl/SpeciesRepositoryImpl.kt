package com.example.app.data.repository.impl

import com.example.app.data.remote.Api
import com.example.app.data.remote.auto_gen.species.SpeciesResultData
import com.example.app.data.repository.SpeciesRepository
import com.example.app.data.repository.dto.SpeciesResultDto
import kotlinx.coroutines.delay
import javax.inject.Inject

class SpeciesRepositoryImpl @Inject constructor(
    private val api: Api
): SpeciesRepository {
    override suspend fun searchSpecies(idOrName: String): SpeciesResultDto {
        // 必要によりキャッシュ等の処理を追加する

        // APIを使用してデータ取得
        val speciesResultData = api.species(idOrName)

        // 必要データを取得
        val pokemonNameJp = getPokemonNameJp(speciesResultData)
        val pokemonTypeJp = getPokemonTypeJp(speciesResultData)
        val flavorTextsJp = getFlavorTextJp(speciesResultData)
        val id = speciesResultData.id!! // IDは必ず取得できる想定

        // 取得したデータをDtoに変換
        val speciesResultDto = SpeciesResultDto(
            baseHappiness = speciesResultData.baseHappiness ?: 0,
            id = id,
            name = pokemonNameJp,
            type = pokemonTypeJp,
            flavorTexts = flavorTextsJp,
            officialArtworkUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${id}.png",
        )

        return speciesResultDto
    }

    /**
     * ポケモン名（日本語）を取得
     */
    private fun getPokemonNameJp(speciesResultData: SpeciesResultData): String {
        val ret = speciesResultData.names?.filter {
            it.language?.name == "ja"
        }?.mapNotNull {
            it.name
        }?.firstOrNull() ?: "none"
        return ret
    }

    /**
     * タイプ（日本語）を取得
     */
    private fun getPokemonTypeJp(speciesResultData: SpeciesResultData): String {
        val ret = speciesResultData.genera?.filter {
            it.language?.name == "ja"
        }?.mapNotNull {
            it.genus
        }?.firstOrNull() ?: "none"
        println(">>>ret: $ret")
        return ret
    }

    /**
     * フレーバーテキスト（日本語）を取得
     */
    private fun getFlavorTextJp(speciesResultData: SpeciesResultData): List<String> {
        val ret = speciesResultData.flavorTextEntries?.filter {
            it.language?.name == "ja-Hrkt" && (it.version?.name == "sword" || it.version?.name == "shield")
        }?.mapNotNull {
            it.flavorText?.replace("\n", "")
        }?.distinct()?: listOf()
        println(">>>ret: $ret")
        return ret
    }
}