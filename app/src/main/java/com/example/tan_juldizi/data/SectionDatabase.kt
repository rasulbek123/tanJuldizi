package com.example.tan_juldizi.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tan_juldizi.data.dao.SectionDao
import com.example.tan_juldizi.data.model.Department
import com.example.tan_juldizi.data.model.Section
import com.example.tan_juldizi.data.model.Song

@Database(entities = [Section::class, Song::class,Department::class],version = 1,exportSchema = false)
abstract class SectionDatabase: RoomDatabase() {
    companion object {
        private lateinit var INSTANCE: SectionDatabase
        fun getInstance(context: Context): SectionDatabase =
            Room.databaseBuilder(
                    context,
                    SectionDatabase::class.java, "Tan_Juldiz.db"

            )       .createFromAsset("Tan_Juldiz.db")
                    .allowMainThreadQueries()
                    .build()

        }


    abstract fun dao(): SectionDao
}