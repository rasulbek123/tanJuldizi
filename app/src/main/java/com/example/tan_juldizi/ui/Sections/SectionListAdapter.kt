package com.example.tan_juldizi.ui.Sections

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tan_juldizi.R
import com.example.tan_juldizi.data.model.Section
import kotlinx.android.synthetic.main.item_home.view.*

class SectionListAdapter:RecyclerView.Adapter<SectionListAdapter.SectionViewHolder>() {
    var models:List<Section> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    inner class SectionViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun populeatmodel(section:Section){
        itemView.sectionName.text = section.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_home,parent,false)
        return SectionViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.populeatmodel(models[position])
    }

    override fun getItemCount(): Int = models.size
}