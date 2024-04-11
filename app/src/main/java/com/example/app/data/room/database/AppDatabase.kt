package com.example.app.data.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.app.data.room.dao.UserDao
import com.example.app.data.room.entity.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}