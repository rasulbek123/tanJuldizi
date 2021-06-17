package com.example.tan_juldizi.ui.text

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tan_juldizi.R
import com.example.tan_juldizi.data.SectionDatabase
import com.example.tan_juldizi.data.dao.SectionDao
import com.example.tan_juldizi.ui.Sections.HomeFragment
import com.example.tan_juldizi.ui.song.SongFragment
import com.example.tan_juldizi.ui.song.SongListAdapter
import kotlinx.android.synthetic.main.text_fragment.*

class TextFragment:Fragment(R.layout.text_fragment) {
    private lateinit var  tvTextDao:SectionDao
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvTextDao = SectionDatabase.getInstance(requireContext()).dao()
        val textId = arguments?.getInt(HomeFragment.TEXT_ID) ?:1
        tvText.text = tvTextDao.getTextBySongId(textId)
        val tvFragment = TextFragment()

    }
}