package com.example.endeavorapp.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.endeavorapp.R
import com.example.endeavorapp.ui.fragment.*
import kotlinx.android.synthetic.main.activity_home.*



class HomeActivity : AppCompatActivity() {
    private lateinit var mSharedPref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val toolbar: Toolbar = findViewById(R.id.app_bar)
        setSupportActionBar(toolbar)
        mSharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        val email=mSharedPref.getString(EMAIL, "").toString()
        println("Dans l'activity Home"+email)
        addFragment(HomeFragment.newInstance())
        bottomNavigation.show(0)
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
        }


    }
    private fun replaceFragment(fragment:Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.fragment_container,fragment).addToBackStack(Fragment::class.java.simpleName).commit()
    }

    private fun addFragment(fragment:Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.add(R.id.fragment_container,fragment).addToBackStack(Fragment::class.java.simpleName).commit()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menuout, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.infoMenu -> {

//                val aboutMeFragment = AboutMeFragment.newInstance(
//                    intent.getStringExtra(FULL_NAME).toString(),
//                    intent.getStringExtra(AGE).toString(),
//                    intent.getStringExtra(GENDER).toString(),
//                    intent.getStringExtra(EMAIL).toString())

           /*     val aboutMeFragment = AboutMeFragment.newInstance(
                    mSharedPref.getString(FULL_NAME, "").toString(),
                    mSharedPref.getString(AGE, "").toString(),
                    mSharedPref.getString(GENDER, "").toString(),
                    mSharedPref.getString(EMAIL, "").toString()
                )

                changeFragment(aboutMeFragment,"AboutMe")*/
            }
            R.id.logoutMenu ->{
                val builder = AlertDialog.Builder(this)
                builder.setTitle(getString(R.string.logoutTitle))
                builder.setMessage(R.string.logoutMessage)
                builder.setPositiveButton("Yes"){ dialogInterface, which ->
                    getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit().clear().apply()
                    val intent = Intent(this@HomeActivity, LogActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                builder.setNegativeButton("No"){dialogInterface, which ->
                    dialogInterface.dismiss()
                }
                builder.create().show()
            }

        }

        return super.onOptionsItemSelected(item)

    }


}