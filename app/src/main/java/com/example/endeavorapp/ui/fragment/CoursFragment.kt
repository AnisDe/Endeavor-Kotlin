package com.example.endeavorapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.endeavorapp.R
import com.example.endeavorapp.data.Cour
import com.example.endeavorapp.list.CourAdapter
import java.lang.System.console
import kotlin.math.log

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CoursFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CoursFragment : Fragment() {
    lateinit var lsvCour: ListView
    lateinit var imgCour : ImageView
    lateinit var txtNameCour : TextView
    lateinit var txtAbnCour : TextView
    lateinit var adapter : CourAdapter
    lateinit var view : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_cours, container, false)
        view = rootView.findViewById(R.id.lsvCour)

        var courList : MutableList<Cour> = ArrayList()
        // while(courList.size <10){
        courList.add(Cour(0,"2 Abonner", "Java", R.drawable.java_logo))
        courList.add(Cour(1,"30 Abonner", "Java Script", R.drawable.javascript))
        courList.add(Cour(2,"22 Abonner", "PYTHON", R.drawable.python_logo))
        courList.add(Cour(3,"12 Abonner", "CSS", R.drawable.css_logo))
        courList.add(Cour(4,"122 Abonner", "SQL", R.drawable.sql_logo))
        courList.add(Cour(5,"182 Abonner", "C#", R.drawable.csharp_logo))
        //  }
        println("yyyyy"+courList.size)
        adapter = CourAdapter(courList)
        view.adapter =adapter
        view.layoutManager= LinearLayoutManager(this.context,LinearLayoutManager.VERTICAL,false)

        return rootView
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            CoursFragment().apply {
                arguments = Bundle().apply {
                    // putString(ARG_PARAM1, param1)
                    // putString(ARG_PARAM2, param2)
                }
            }
    }
}