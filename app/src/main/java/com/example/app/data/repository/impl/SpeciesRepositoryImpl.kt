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

        // 取得したデータをDtoに変換
        val speciesResultDto = SpeciesResultDto(
            baseHappiness = speciesResultData.baseHappiness ?: 0,
            id = speciesResultData.id ?: 0,
            name = pokemonNameJp,
            type = pokemonTypeJp,
            flavorTexts = flavorTextsJp
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
            it.language?.name == "ja-Hrkt"
        }?.mapNotNull {
            it.flavorText?.replace("\n", "")
        }?.distinct()?: listOf()
        println(">>>ret: $ret")
        return ret
    }
}