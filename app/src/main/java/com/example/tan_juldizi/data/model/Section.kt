package com.example.tan_juldizi.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "Category")
data class Section(
    @PrimaryKey val id :Int,
    @ColumnInfo(name = "name") val name:String,
    @ColumnInfo(name = "is_divides") val isDivides:Int
)
