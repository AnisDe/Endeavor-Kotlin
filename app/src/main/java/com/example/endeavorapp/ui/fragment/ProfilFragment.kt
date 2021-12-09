package com.example.endeavorapp.ui.fragment

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.endeavorapp.R
import com.example.endeavorapp.list.CourTargetAdapter
import com.example.endeavorapp.ui.AGE
import com.example.endeavorapp.ui.EMAILl
import com.example.endeavorapp.ui.NAME




class ProfilFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    lateinit var imgProfil : ImageView
    lateinit var txtName : TextView
    lateinit var txtEmail : TextView
    lateinit var imgSetg : ImageView
    lateinit var btChang : Button
    lateinit var recylcerCourTarget: RecyclerView
    lateinit var recylcerCourTargetAdapter: CourTargetAdapter
    private lateinit var mSharedPref: SharedPreferences


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_profil, container, false)
       // bottom_navigation.selectedItemId = R.id.Home

        imgProfil = rootView.findViewById(R.id.imageProfil)
        txtName = rootView.findViewById(R.id.txtNomProfil)
        txtEmail = rootView.findViewById(R.id.txtEmailFProfil)
        imgSetg = rootView.findViewById(R.id.imageSettingProfil)
        btChang = rootView.findViewById(R.id.btnChangPWDProfil)


        txtEmail.isEnabled = false
        txtName.isEnabled = false


        val email =requireArguments().getString(EMAILl, "NULL")
        val name = requireArguments().getString(NAME , "NULL")
        txtName.text= "$name "


        /*recylcerCourTarget = rootView.findViewById(R.id.recycleViewCF)
        var courList : MutableList<CourTarget> = ArrayList()

        courList.add(CourTarget(idCourTarget = 1,nameCour = "JEE", targetCour = 3 ,activationCour = true))
        courList.add(CourTarget(idCourTarget = 2, nameCour = "JAVA", targetCour = 4 ,activationCour = true ))

        recylcerCourTargetAdapter = CourTargetAdapter(courList)

        recylcerCourTarget.adapter = recylcerCourTargetAdapter

        recylcerCourTarget.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL,false)*/







        return rootView
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfilFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(email: String, name: String, age: String) =
            ProfilFragment().apply {
                arguments = Bundle().apply {
                    putString(EMAILl, email)
                    putString(NAME , name)
                    putString(AGE , age)
                }
            }
    }


}