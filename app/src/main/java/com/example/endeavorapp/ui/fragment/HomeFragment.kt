package com.example.endeavorapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.endeavorapp.R
import com.example.endeavorapp.data.Cour
import com.example.endeavorapp.list.CourHomeAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    lateinit var adapter : CourHomeAdapter
    lateinit var view : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        view = rootView.findViewById(R.id.rv_main_category)
        var courList : MutableList<Cour> = ArrayList()
        courList.add(Cour(0,"2 Abonner", "Java", R.drawable.java_logo))
        courList.add(Cour(1,"30 Abonner", "Java Script", R.drawable.javascript))
        courList.add(Cour(2,"22 Abonner", "PYTHON", R.drawable.python_logo))
        courList.add(Cour(3,"12 Abonner", "CSS", R.drawable.css_logo))

        adapter = CourHomeAdapter(courList)
        view.adapter =adapter
        view.layoutManager= LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL,false)


        // Inflate the layout for this fragment
        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}