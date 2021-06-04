package com.example.tan_juldizi.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.tan_juldizi.data.model.Section

@Dao
interface SectionDao {
    @Query("SELECT * FROM Category")
    fun getAllSection():List<Section>
}