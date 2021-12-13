package com.example.endeavorapp.list

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.endeavorapp.R
import com.example.endeavorapp.data.Cour
import com.example.endeavorapp.ui.LetCodingActivity
import com.example.endeavorapp.ui.fragment.CoursFragment

class CourAdapter (val courList: MutableList<Cour>) : RecyclerView.Adapter<CourViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cour_item, parent, false)

        return CourViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourViewHolder, position: Int) {
        val Name = courList[position].nameCour
        val abn = courList[position].numAb

        holder.courName.text = Name
        holder.courAb.text = abn
        holder.courImg.setImageResource(courList[position].ImageCour)

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, LetCodingActivity::class.java)
            intent.apply {
                putExtra("NAME", Name)
                putExtra("ABN", abn)
                putExtra("PICTURE", courList[position].ImageCour)
            }
            holder.itemView.context.startActivities(arrayOf(intent))
        }
    }

    override fun getItemCount()= courList.size

}