package com.example.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities={Album.class,Song.class,AlbumSong.class},version=1)
public abstract class MusicDataBase extends RoomDatabase {
    abstract MusicDao getMusicDao();
}
