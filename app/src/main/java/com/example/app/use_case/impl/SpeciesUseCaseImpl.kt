package com.example.app.use_case.impl

import com.example.app.common.StateNotice
import com.example.app.data.repository.SpeciesRepository
import com.example.app.data.repository.dto.SpeciesResultDto
import com.example.app.use_case.SpeciesUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SpeciesUseCaseImpl @Inject constructor(
    private val speciesRepository: SpeciesRepository
): SpeciesUseCase {
    override suspend fun searchSpecies(idOrName: String): SpeciesResultDto {
        delay(1000L) // 試験的に待ちを入れる
        val ret = speciesRepository.searchSpecies(idOrName)
        return ret
    }

    override fun searchSpeciesFlow(idOrName: String): Flow<StateNotice<SpeciesResultDto>> = flow {
        emit(StateNotice.Loading<SpeciesResultDto>())

        try {
            delay(1000L) // 試験的に待ちを入れる
            val ret = speciesRepository.searchSpecies(idOrName)
            emit(StateNotice.Success<SpeciesResultDto>(ret))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(StateNotice.Failure<SpeciesResultDto>(e.message.toString()))
        }
    }
}