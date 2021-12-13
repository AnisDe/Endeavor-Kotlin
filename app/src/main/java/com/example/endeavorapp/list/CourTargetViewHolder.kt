package com.example.endeavorapp.list

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.endeavorapp.R

class CourTargetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val courName : TextView
    val courTarget : ProgressBar

    init {
        courName = itemView.findViewById<TextView>(R.id.textNameFC)
        courTarget = itemView.findViewById<ProgressBar>(R.id.progressBarFC)
    }
}