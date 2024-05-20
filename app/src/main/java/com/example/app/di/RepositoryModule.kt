package com.example.app.di

import android.content.Context
import androidx.room.Room
import com.example.app.common.Constants.BASE_URL
import com.example.app.data.remote.Api
import com.example.app.data.repository.SpeciesRepository
import com.example.app.data.repository.impl.SpeciesRepositoryImpl
import com.example.app.data.room.database.AppDatabase
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton
import com.example.app.data.room.dao.UserDao

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



    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "pokemon_db").build()
    }

    @Provides
    fun provideUserDao(db: AppDatabase): UserDao {
        return db.userDao()
    }
}