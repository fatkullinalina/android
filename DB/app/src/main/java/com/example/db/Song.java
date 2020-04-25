package com.example.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Song {
    @PrimaryKey
    @ColumnInfo(name="id")
    private int mId;
    @ColumnInfo(name="name")
    private String mName;
    @ColumnInfo(name="duration")
    private String mDuration;

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getDuration() {
        return mDuration;
    }

    public void setDuration(String mDuration) {
        this.mDuration = mDuration;
    }

    public Song() {
    }

    public Song(int mId, String mName, String mDuration) {
        this.mId = mId;
        this.mName = mName;
        this.mDuration = mDuration;
    }
}
