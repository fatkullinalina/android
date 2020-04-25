package com.example.gif;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {AGif.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract GifDao gifDao();
}

