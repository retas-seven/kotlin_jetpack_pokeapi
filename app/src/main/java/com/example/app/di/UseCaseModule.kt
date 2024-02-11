package com.example.app.di

import com.example.app.data.repository.SpeciesRepository
import com.example.app.use_case.SpeciesUseCase
import com.example.app.use_case.impl.SpeciesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideSpeciesUseCase(speciesRepository: SpeciesRepository): SpeciesUseCase {
        return SpeciesUseCaseImpl(speciesRepository)
    }
}