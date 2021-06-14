package com.example.tan_juldizi.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Department")
data class Department(
    @PrimaryKey val id:Int,
    @ColumnInfo(name = "name") val departmentName:String,
    @ColumnInfo(name = "category_id") val categoryId:Int
)
