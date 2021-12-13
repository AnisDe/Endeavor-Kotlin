package com.example.endeavorapp.list

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.endeavorapp.R
import com.example.endeavorapp.data.Cour
import com.example.endeavorapp.ui.fragment.CoursFragment
import com.example.endeavorapp.ui.fragment.HomeFragment

class CourHomeAdapter (val courList: MutableList<Cour>) : RecyclerView.Adapter<CourHomeViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourHomeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_rv_main_category, parent, false)

        return CourHomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourHomeViewHolder, position: Int) {
        val Name = courList[position].nameCour
    //    val abn = courList[position].numAb

        holder.courName.text = Name
    //    holder.courAb.text = abn
        holder.courImg.setImageResource(courList[position].ImageCour)

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, HomeFragment::class.java)
            intent.apply {
                putExtra("NAME", Name)
             //   putExtra("ABN", abn)
                putExtra("PICTURE", courList[position].ImageCour)
            }
            holder.itemView.context.startService(intent)
        }
    }

    override fun getItemCount()= courList.size


}