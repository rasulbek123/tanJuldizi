package com.example.tan_juldizi.ui.song

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tan_juldizi.MainActivity
import com.example.tan_juldizi.R
import com.example.tan_juldizi.data.SongDatabase
import com.example.tan_juldizi.data.dao.SongDao
import com.example.tan_juldizi.ui.Sections.HomeFragment
import kotlinx.android.synthetic.main.song_fragment.*

class SongFragment:Fragment(R.layout.song_fragment) {
    private var songAdapter = SongListAdapter()
    private lateinit var songDao:SongDao
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        songRecyclerView.adapter = songAdapter
        val songName = arguments?.getInt(MainActivity.TYPE_ID) ?:1
        songDao = SongDatabase.getSongInstance(requireContext()).DaoSong()
        setDataSong(songName)
    }
    fun setDataSong(songName:Int){
        songAdapter.songModel = songDao.getAllSong(songName)
    }
}