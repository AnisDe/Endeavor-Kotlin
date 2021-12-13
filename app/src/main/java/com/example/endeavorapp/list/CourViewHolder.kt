package com.example.endeavorapp.list

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.endeavorapp.R

class CourViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var courName : TextView
    var courAb : TextView
    var courImg : ImageView


    init {
        courAb = itemView.findViewById<TextView>(R.id.txtAbnCourItem)
        courName = itemView.findViewById<TextView>(R.id.txtNameCourItem)
        courImg = itemView.findViewById<ImageView>(R.id.imgLogoNameItem)
    }
}