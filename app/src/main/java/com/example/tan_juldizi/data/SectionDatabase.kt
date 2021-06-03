package com.example.tan_juldizi.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tan_juldizi.data.dao.SectionDao
import com.example.tan_juldizi.data.model.Section

@Database(entities = [Section::class],version = 1)
abstract class SectionDatabase: RoomDatabase() {
    companion object {
        private lateinit var INSTANCE: SectionDatabase
        fun getInstance(context: Context): SectionDatabase {
            if (!Companion::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    SectionDatabase::class.java,
                    "Tan_Juldiz"
                ).createFromAsset("Tan_Juldiz")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
    abstract fun dao(): SectionDao
}