package com.example.endeavorapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.endeavorapp.R
import com.example.endeavorapp.ui.fragment.*
import kotlinx.android.synthetic.main.activity_home.*

class LetCodingActivity : AppCompatActivity() {
    lateinit var test :TextView
    lateinit var imgLogo :ImageView
    lateinit var butGo :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_let_coding)

        test = findViewById(R.id.textViewtest)
        imgLogo= findViewById(R.id.imageCoding)
        butGo =findViewById(R.id.ButtonGO)
        val tex ="WELCOME TO LANGUAGE "+intent.getStringExtra("NAME")
        test.text=tex
        imgLogo.setImageResource(intent.getIntExtra("PICTURE", 0))

      //  addFragment(HomeFragment.newInstance())
      /*  bottomNavigation.show(2)
        bottomNavigation.add(MeowBottomNavigation.Model(0,R.drawable.ic_home))
        bottomNavigation.add(MeowBottomNavigation.Model(1,R.drawable.ic_person))
        bottomNavigation.add(MeowBottomNavigation.Model(2,R.drawable.ic_book))
        bottomNavigation.add(MeowBottomNavigation.Model(3,R.drawable.ic_chat))
        bottomNavigation.add(MeowBottomNavigation.Model(4,R.drawable.ic_notifications))

        bottomNavigation.setOnClickMenuListener {
            when(it.id){
                0 -> {
                    replaceFragment(HomeFragment.newInstance())
                }
                1 -> {
                    //  val profilFragment = ProfilFragment.newInstance(email)
                    // mSharedPref.putString(EMAIL, "").toString())
                    //  mSharedPref.edit().apply {
                    //     putString(EMAIL," Email.text.toString()")
                    // })

                    replaceFragment(ProfilFragment.newInstance())
                }
                2 -> {
                    replaceFragment(CoursFragment.newInstance())
                }
                3 -> {
                    replaceFragment(ChatFragment.newInstance())
                }
                4 -> {
                    replaceFragment(NotificationFragment.newInstance())
                }
                else -> {
                    replaceFragment(HomeFragment.newInstance())
                }
            }
        }*/

        butGo.setOnClickListener {
            val intent = Intent(this@LetCodingActivity, MenuLevelActivity::class.java)
            intent.apply {
                putExtra("NAME", intent.getStringExtra("NAME").toString())
            }
            startActivity(intent)
            finish()
        }
    }
    private fun replaceFragment(fragment:Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.fragment_container,fragment).addToBackStack(Fragment::class.java.simpleName).commit()
    }
    private fun addFragment(fragment: Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.add(R.id.fragment_container,fragment).addToBackStack(Fragment::class.java.simpleName).commit()
    }

}