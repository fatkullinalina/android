package com.example.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MusicDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAlbums(List<Album> albums);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSongs(List<Song> songs);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void setLinksAlbumSong(List<AlbumSong> linksAlbumSong);

    @Query("select * from album")
    List<Album> getAlbums();

    @Query("select * from song")
    List<Song> getSongs();

    @Delete
    void deleteAlbum(Album album);

    @Query("select * from song inner join albumsong on song.id=albumsong.song_id where album_id=:albumId")
    List<Song> getSongsFromAlbum(int albumId);
}
