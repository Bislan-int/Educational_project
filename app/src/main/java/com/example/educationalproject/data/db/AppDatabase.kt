package com.example.educationalproject.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.educationalproject.data.FilmDao
import com.example.educationalproject.domain.Film

@Database(entities = [Film::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
}