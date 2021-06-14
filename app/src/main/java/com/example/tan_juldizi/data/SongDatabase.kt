package com.example.tan_juldizi.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tan_juldizi.data.dao.SongDao
import com.example.tan_juldizi.data.model.Song

@Database(entities = [Song::class],version = 2,exportSchema = false)
abstract class SongDatabase:RoomDatabase() {
    companion object{
        private lateinit var songInstance:SongDatabase
        fun getSongInstance(context: Context):SongDatabase =
            Room.databaseBuilder(
                context,
                SongDatabase::class.java,"Tan_Juldiz.db"
            )   .createFromAsset("Tan_Juldiz.db")
                .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                .build()
    }
    abstract fun DaoSong():SongDao
}