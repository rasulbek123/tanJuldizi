package com.example.tan_juldizi.ui.department

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tan_juldizi.R
import com.example.tan_juldizi.data.model.Department
import kotlinx.android.synthetic.main.item_department.view.*

class DepartmentListAdapter:RecyclerView.Adapter<DepartmentListAdapter.DepartmentViewHolder>() {
    var depModel:List<Department> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    inner class DepartmentViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun populeatmodel(deparment:Department){
            itemView.departmentName.text = deparment.departmentName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepartmentViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_department,parent,false)
        return DepartmentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DepartmentViewHolder, position: Int) {
        holder.populeatmodel(depModel[position])
    }

    override fun getItemCount(): Int = depModel.size
}