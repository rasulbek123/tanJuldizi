package com.example.tan_juldizi.data

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.tan_juldizi.data.dao.DepartmentDao
import com.example.tan_juldizi.data.model.Department

@Database(entities = [Department::class],version = 2,exportSchema = false)
abstract class DepartmentDatabase:RoomDatabase() {
    companion object{
    private lateinit var depInstance:DepartmentDatabase
    fun getDepInstance(context: Context):DepartmentDatabase =
        Room.databaseBuilder(
            context,
            DepartmentDatabase::class.java,"Tan_Juldiz.db"
        )   .createFromAsset("Tan_Juldiz.db")
            .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
            .build()
}

    abstract fun DepartmentDao(): DepartmentDao
}