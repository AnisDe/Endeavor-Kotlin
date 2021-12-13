package com.example.endeavorapp.ui.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.endeavorapp.R
import com.example.endeavorapp.data.CourTarget
import com.example.endeavorapp.list.CourTargetAdapter
import com.example.endeavorapp.ui.EMAIL
import com.example.endeavorapp.ui.PREF_NAME



class ProfilFragment : Fragment() {

    lateinit var imgProfil : ImageView
    lateinit var txtName : TextView
    lateinit var txtEmail : TextView
    lateinit var imgSetg : ImageView
    lateinit var btChang : Button
    lateinit var recylcerCourTarget: RecyclerView
    lateinit var recylcerCourTargetAdapter: CourTargetAdapter
    lateinit var mSharedPref: SharedPreferences


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_profil, container, false)




        return rootView
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imgProfil = view.findViewById(R.id.imageProfil)
        txtName = view.findViewById(R.id.txtNomProfil)
        txtEmail = view.findViewById(R.id.txtEmailFProfil)
        imgSetg = view.findViewById(R.id.imageSettingProfil)
        btChang = view.findViewById(R.id.btnChangPWDProfil)
        txtEmail.isEnabled = false
        mSharedPref = view.context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        val email =mSharedPref.getString(EMAIL,"").toString()
        println("this is the variable Email dans le frag Profil"+email)
        txtEmail.text=email
        recylcerCourTarget = view.findViewById(R.id.recycleViewCF)
        var courList : MutableList<CourTarget> = ArrayList()

        courList.add(CourTarget(idCourTarget = 1,nameCour = "JEE", targetCour = 3 ,activationCour = true))
        courList.add(CourTarget(idCourTarget = 2, nameCour = "JAVA", targetCour = 4 ,activationCour = true ))

        recylcerCourTargetAdapter = CourTargetAdapter(courList)

        recylcerCourTarget.adapter = recylcerCourTargetAdapter

        recylcerCourTarget.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL,false)

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
        fun newInstance() =
            ProfilFragment().apply {
                arguments = Bundle().apply {
                   // putString(EMAIL, email)
                }
            }
    }
}