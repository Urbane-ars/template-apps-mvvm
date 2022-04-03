package com.example.template.datasource.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SomeData::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun someDataDAO(): SomeDataDAO
}