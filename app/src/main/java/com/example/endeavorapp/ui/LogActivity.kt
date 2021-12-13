package com.example.endeavorapp.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.example.endeavorapp.R
import com.example.endeavorapp.model.User

import com.example.endeavorapp.Retrofit.*

import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.textfield.TextInputEditText
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

const val EMAIL = "EMAIL"
const val PREF_NAME = "PREF_NAME"
const val IS_REMEMBERED ="IS_REMEMBERED"


    class LogActivity : AppCompatActivity() {

        private lateinit var mSharedPref: SharedPreferences

        lateinit var services: Services
        internal var compositeDisposable = CompositeDisposable()
        lateinit var progBar: CircularProgressIndicator
        lateinit var btn_login: Button
        lateinit var Email : TextInputEditText
        lateinit var Password : TextInputEditText
        lateinit var bForget : Button
        lateinit var bInsc : Button
        lateinit var cbRememberMe: CheckBox


        override fun onStop() {
            compositeDisposable.clear()
            super.onStop()
        }
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_log)

            mSharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

            bForget = findViewById(R.id.btnForgetLog)
            bInsc = findViewById(R.id.btnInscitLog)
            btn_login = findViewById(R.id.btnLoginLog)
            Email = findViewById(R.id.txtEmailLog)
            Password = findViewById(R.id.txtPwdLog)
            progBar = findViewById(R.id.progBar)
            progBar.visibility = View.INVISIBLE
            cbRememberMe = findViewById(R.id.cbRememberMe)



            val retrofit =  RetrofitClient.getInstance()
            services = retrofit.create(Services::class.java)


            btn_login.setOnClickListener{
                progBar.visibility = View.VISIBLE
                if (login( Email.text.toString() , Password.text.toString())){
                    intent = Intent(this@LogActivity, HomeActivity::class.java)
                    println("Dans l'activity login"+Email.text.toString())
                    startActivity(intent)
                    finish()

                }
                if (cbRememberMe.isChecked){
                    mSharedPref.edit().apply{
                        putBoolean(IS_REMEMBERED, cbRememberMe.isChecked)
                    }.apply()
                }
                progBar.visibility = View.INVISIBLE


            }

            bInsc.setOnClickListener {
                val intent = Intent(this@LogActivity, InscritActivity::class.java)
                startActivity(intent)
                finish()
            }



        }

        private fun login(email: String, password: String) :Boolean{



            if (TextUtils.isEmpty(email)){
                Toast.makeText(this@LogActivity,"Email ne peut pas etre vide",Toast.LENGTH_SHORT).show()
                return false;
            }

            if (TextUtils.isEmpty(password)){
                Toast.makeText(this@LogActivity,"password ne peut pas etre vide",Toast.LENGTH_SHORT).show()
                return false;
            }

            compositeDisposable.addAll(services.login(email,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {result -> Toast.makeText(this@LogActivity ,""+result,Toast.LENGTH_SHORT).show()
                    mSharedPref.edit().apply{
                        putString(EMAIL,Email.text.toString()).apply()
                        putBoolean(IS_REMEMBERED, cbRememberMe.isChecked)}
                }

            )
            return true;
        }


    }