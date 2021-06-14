package com.example.tan_juldizi.ui.department

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tan_juldizi.MainActivity
import com.example.tan_juldizi.R
import com.example.tan_juldizi.data.DepartmentDatabase
import com.example.tan_juldizi.data.dao.DepartmentDao
import com.example.tan_juldizi.ui.Sections.HomeFragment
import kotlinx.android.synthetic.main.department_fragment.*

class DepartmentFragment:Fragment(R.layout.department_fragment) {
    private var departmentAdapter = DepartmentListAdapter()
    private lateinit var daoDepartment:DepartmentDao
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        departmentRecyclerView.adapter = departmentAdapter
        val departmentName = arguments?.getInt(MainActivity.TYPE_ID) ?:1
        daoDepartment = DepartmentDatabase.getDepInstance(requireContext()).DepartmentDao()
        SetDataDepartment(departmentName)
    }
    fun SetDataDepartment(departmentName:Int){
        departmentAdapter.depModel = daoDepartment.getAllDepartment(departmentName)
    }
}