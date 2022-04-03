package com.example.template.datasource.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SomeDataDAO {
    @Insert
    fun add(someData: SomeData?)

    @Delete
    fun delete(someData: SomeData?)

    @get:Query("SELECT * FROM SomeData")
    val all: List<SomeData>?
}