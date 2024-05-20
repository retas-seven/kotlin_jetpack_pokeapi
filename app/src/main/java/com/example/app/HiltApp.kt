package com.example.app

import android.app.Application
import androidx.room.Room
import com.example.app.data.room.database.AppDatabase
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class HiltApp : Application() {
//    companion object {
//        var db: AppDatabase? = null
//    }
    override fun onCreate() {
        super.onCreate()
        // Roomのインスタンスを生成
//        db = Room.databaseBuilder(applicationContext,
//            AppDatabase::class.java, "pokemon_db").build()

        // Timberの初期化
        Timber.plant(Timber.DebugTree())
    }
}