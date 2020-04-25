package com.example.gif;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface GifDao {
    @Query("SELECT * FROM agif")
    List<AGif> getAll();

    @Query("SELECT * FROM agif WHERE id = :id")
    AGif getById(long id);

    @Insert
    void insert(AGif agif);

    @Insert
    void insertAll(List<AGif> agif);

    @Update
    void update(AGif agif);

    @Delete
    void delete(AGif agif);
}
