package com.example.template.di

import android.content.Context
import androidx.room.Room
import com.example.template.App
import com.example.template.datasource.db.AppDatabase
import com.example.template.datasource.db.SomeDataDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule(app: App) {
    private val context: Context = app.applicationContext

    @Singleton
    @Provides
    fun providesSomeDataDAO(): SomeDataDAO {
        return Room.databaseBuilder(context, AppDatabase::class.java, "appData").allowMainThreadQueries().build().someDataDAO() // TODO asynchronously run the query
    }

}