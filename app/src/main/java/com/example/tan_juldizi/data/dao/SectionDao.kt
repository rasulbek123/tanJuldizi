package com.example.tan_juldizi.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.tan_juldizi.data.model.Department
import com.example.tan_juldizi.data.model.Section
import com.example.tan_juldizi.data.model.Song
import org.w3c.dom.Text


@Dao
interface SectionDao {
    @Query("SELECT * FROM Category")
    fun getAllSection():List<Section>
    @Query("SELECT * FROM Department WHERE category_id = :departmentName")
    fun getAllDepartment(departmentName:Int):List<Department>
    @Query("SELECT * FROM Department WHERE category_id = :id")
    fun getDepartmentBySectionId(id:Int) : List<Department>
    @Query("SELECT * FROM Qosiqlar WHERE category_id = :songId")
    fun getAllSong(songId:Int):List<Song>
    @Query("SELECT text FROM Qosiqlar WHERE id = :textId")
    fun getTextBySongId(textId:Int):String
}