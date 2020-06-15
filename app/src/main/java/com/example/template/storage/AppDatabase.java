package com.example.template.storage;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {SomeData.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SomeDataDAO someDataDAO();

}
