package com.example.template.datasource.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.inject.Inject

@Entity
class SomeData @Inject constructor() {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id = 0

    @ColumnInfo(name = "content")
    var content: String? = null
    override fun toString(): String {
        return String.format("id: %s; content: %s ", id, content)
    }
}