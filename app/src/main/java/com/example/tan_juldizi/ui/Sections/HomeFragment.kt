package com.example.tan_juldizi.ui.Sections

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tan_juldizi.R
import com.example.tan_juldizi.data.SectionDatabase
import com.example.tan_juldizi.data.dao.SectionDao
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment:Fragment(R.layout.fragment_home) {
    private var adapter = SectionListAdapter()
    private lateinit var dao:SectionDao
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sectionRecycler.adapter = adapter
        dao = SectionDatabase.getInstance(requireContext()).dao()
        setData()
    }
    private fun setData(){
        adapter.models = dao.getAllSection()
    }
}