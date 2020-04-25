package com.example.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Album {
    @PrimaryKey
    @ColumnInfo(name="id")
    private int mId;
    @ColumnInfo(name="name")
    private String mName;
    @ColumnInfo(name="release")
    private String mRealeseDate;

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

    public String getRealeseDate() {
        return mRealeseDate;
    }

    public void setRealeseDate(String mRealeseDate) {
        this.mRealeseDate = mRealeseDate;
    }

    public Album(int mId, String mName, String mRealeseDate) {
        this.mId = mId;
        this.mName = mName;
        this.mRealeseDate = mRealeseDate;
    }

    @Override
    public String toString() {
        return mId + ": " + mName + ", Релиз " + mRealeseDate + '\n';
    }



    public Album() {
    }
}
