package com.example.tan_juldizi.ui.department

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tan_juldizi.MainActivity
import com.example.tan_juldizi.R
import com.example.tan_juldizi.data.SectionDatabase
import com.example.tan_juldizi.data.dao.SectionDao
import com.example.tan_juldizi.ui.Sections.HomeFragment
import kotlinx.android.synthetic.main.department_fragment.*

class DepartmentFragment:Fragment(R.layout.department_fragment) {
    private var departmentAdapter = DepartmentListAdapter()
    private lateinit var daoDepartment:SectionDao
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        departmentRecyclerView.adapter = departmentAdapter
        val sectionId = arguments?.getInt(HomeFragment.SECTION_ID) ?:1
        daoDepartment = SectionDatabase.getInstance(requireContext()).dao()
        SetDataDepartment(sectionId)
    }
    fun SetDataDepartment(sectionId:Int){
        departmentAdapter.depModel = daoDepartment.getDepartmentBySectionId(sectionId)
    }
}