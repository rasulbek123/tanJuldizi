package com.example.tan_juldizi.ui.song

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tan_juldizi.R
import com.example.tan_juldizi.data.model.Song
import kotlinx.android.synthetic.main.item_song.view.*

class SongListAdapter:RecyclerView.Adapter<SongListAdapter.SongViewHolder>() {
    var songModel:List<Song> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    inner class SongViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun populeatmodel(song:Song){
            itemView.songName.text = song.songName
            itemView.setOnClickListener {
                songItemClicked.invoke(song)
            }
        }
    }
    var songItemClicked:(song:Song)->Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_song,parent,false)
        return SongViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.populeatmodel(songModel[position])
    }

    override fun getItemCount(): Int = songModel.size
}