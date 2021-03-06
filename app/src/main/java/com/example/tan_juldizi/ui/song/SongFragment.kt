package com.example.tan_juldizi.ui.song

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tan_juldizi.MainActivity
import com.example.tan_juldizi.R
import com.example.tan_juldizi.data.SectionDatabase
import com.example.tan_juldizi.data.dao.SectionDao
import com.example.tan_juldizi.ui.Sections.HomeFragment
import kotlinx.android.synthetic.main.song_fragment.*

class SongFragment:Fragment(R.layout.song_fragment) {
    private var songAdapter = SongListAdapter()
    private lateinit var songDao:SectionDao
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        songRecyclerView.adapter = songAdapter
        val songId = arguments?.getInt(HomeFragment.SECTION_ID) ?:1
        songDao = SectionDatabase.getInstance(requireContext()).dao()
        setDataSong(songId)
    }
    fun setDataSong(songId:Int){
        songAdapter.songModel = songDao.getAllSong(songId)
    }
}