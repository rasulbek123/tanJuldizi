package com.example.tan_juldizi.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Qosiqlar")
data class Song(
    @PrimaryKey val id:Int,
    @ColumnInfo(name = "name") val songName:String,
    @ColumnInfo(name = "text") val songText:String,
    @ColumnInfo(name = "is_favorite") var isFavorite:Int,
    @ColumnInfo(name = "department_id") val departmentId:Int?,
    @ColumnInfo(name = "category_id") val categoryId:Int
)
