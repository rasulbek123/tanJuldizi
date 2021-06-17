package com.example.tan_juldizi.ui.Sections

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tan_juldizi.MainActivity
import com.example.tan_juldizi.R
import com.example.tan_juldizi.data.SectionDatabase
import com.example.tan_juldizi.data.dao.SectionDao
import com.example.tan_juldizi.ui.department.DepartmentFragment
import com.example.tan_juldizi.ui.song.SongFragment
import com.example.tan_juldizi.ui.song.SongListAdapter
import com.example.tan_juldizi.ui.text.TextFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment:Fragment(R.layout.fragment_home) {
    companion object{
        const val SECTION_ID = "typeId"
        const val TEXT_ID = "textId"
    }
    private var adapter = SectionListAdapter()
    private val songAdapter = SongListAdapter()
    private lateinit var dao:SectionDao
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sectionRecycler.adapter = adapter
        dao = SectionDatabase.getInstance(requireContext()).dao()
        adapter.onItemClicked = {
      if(it.isDivides == 1){
            val depFragment = DepartmentFragment()
            val depBundle = Bundle()
            depBundle.putInt(SECTION_ID,it.id)
            depFragment.arguments = depBundle
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragmentContiner,depFragment).addToBackStack("HomeFragment").commit()
        }else{
            val fragment = SongFragment()
            val songBundle = Bundle()
            songBundle.putInt(SECTION_ID,it.id)
            fragment.arguments = songBundle
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragmentContiner,fragment).addToBackStack("HomeFragment").commit()
        }
        }
        songAdapter.songItemClicked = {
            val tvTextFragment = TextFragment()
            val tvTextBundle = Bundle()
            tvTextBundle.putInt(TEXT_ID,it.id)
        }
        setData()
    }
    private fun setData(){
        adapter.models = dao.getAllSection()
    }
}