package com.example.tan_juldizi.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.tan_juldizi.data.model.Department

@Dao
interface DepartmentDao {
    @Query("SELECT * FROM Department WHERE id = :departmentName")
    fun getAllDepartment(departmentName:Int):List<Department>
}