package com.example.endeavorapp.list

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.endeavorapp.R
import com.example.endeavorapp.data.CourTarget
import com.example.endeavorapp.ui.fragment.ProfilFragment

class CourTargetAdapter(val courTargetList: MutableList<CourTarget>) : RecyclerView.Adapter<CourTargetViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourTargetViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_cours_target, parent, false)

        return CourTargetViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourTargetViewHolder, position: Int) {
        val Name = courTargetList[position].nameCour
        val Target = courTargetList[position].targetCour

        holder.courName.text = Name
        holder.courTarget.progress = Target

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, ProfilFragment::class.java)
            intent.apply {
                putExtra("NAME", Name)
                putExtra("TARGET", Target)
            }
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount()= courTargetList.size
}