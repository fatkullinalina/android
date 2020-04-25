package com.example.db;

import android.app.Application;

import androidx.room.Room;

public class AppDelegate extends Application {
    private MusicDataBase musicDataBase;
    @Override
    public void onCreate(){
        super.onCreate();
        musicDataBase= Room.databaseBuilder(this,MusicDataBase.class,"musicdatabase")
                .allowMainThreadQueries()
                .build();
    }

    public MusicDataBase getMusicDataBase() {
        return musicDataBase;
    }
}
