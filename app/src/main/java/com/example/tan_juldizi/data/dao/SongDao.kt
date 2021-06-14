package com.example.tan_juldizi.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.tan_juldizi.data.model.Song

@Dao
interface SongDao {
    @Query("SELECT * FROM Qosiqlar WHERE category_id= :songName")
    fun getAllSong(songName:Int): List<Song>
}