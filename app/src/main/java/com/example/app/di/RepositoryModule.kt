package com.example.app.di

import com.example.app.common.Constants.BASE_URL
import com.example.app.data.remote.Api
import com.example.app.data.repository.SpeciesRepository
import com.example.app.data.repository.impl.SpeciesRepositoryImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Hiltの依存性注入を設定する
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideApi(): Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                )
            )
            .build()
            .create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideSpeciesRepository(api: Api): SpeciesRepository {
        return SpeciesRepositoryImpl(api)
    }
}