package com.example.endeavorapp.ui

import android.content.Context
import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import com.example.endeavorapp.R
import android.util.Log


import com.example.endeavorapp.Retrofit.*
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.textfield.TextInputEditText
import com.example.endeavorapp.model.User
import retrofit2.Response


const val EMAIL = "EMAIL"
const val FULLNAME = "FULLNAME"
const val AGE = "AGE"
const val PASSWORD = "PASSWORD"
const val ID = "ID"
const val PREF_NAME = "PREF_NAME"
const val IS_REMEMBERED ="IS_REMEMBERED"


    class LogActivity : AppCompatActivity() {




        lateinit var progBar: CircularProgressIndicator
        lateinit var btn_login: Button
        lateinit var Email : TextInputEditText
        lateinit var Password : TextInputEditText
        lateinit var bForget : Button
        lateinit var bInsc : Button

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_log)

            bForget = findViewById(R.id.btnForgetLog)
            bInsc = findViewById(R.id.btnInscitLog)
            btn_login = findViewById(R.id.btnLoginLog)
            Email = findViewById(R.id.txtEmailLog)
            Password = findViewById(R.id.txtPwdLog)
            progBar = findViewById(R.id.progBar)
            progBar.visibility = View.INVISIBLE





            var services = Services.create()

            val sharedPreference = getSharedPreferences("userInfo" , Context.MODE_PRIVATE)

            val isConnected = sharedPreference.getBoolean("isConnected" , false)
            if (isConnected) {
                startActivity(Intent(this@LogActivity, HomeActivity::class.java))
                finish()
            }


            btn_login.setOnClickListener{
              val EmailPassValidation =  validation_form(Email.text.toString() , Password.text.toString())
                if (EmailPassValidation) {
                    val map: HashMap<String, String> = HashMap()
                    map["email"] = Email.text.toString()
                    map["password"] = Password.text.toString()
                    Log.e("user",map.toString())
                    services.login(map).enqueue(object : Callback<User> {
                        override fun onResponse(
                            call: Call<User>, response:
                            Response<User>
                        ) {
                            Log.e("//////////////////user ",response.body().toString())
                            val user = response.body()
                            if (user != null) {
                                val sharedPreference = getSharedPreferences("userInfo" , Context.MODE_PRIVATE)


                                    sharedPreference.edit().apply{
                                        putBoolean("isConnected", true)
                                        putString(EMAIL, user.email)
                                        putString(FULLNAME, user.name)
                                        putInt(AGE, user.age)
                                        putString(PASSWORD, user.password)
                                        putString(ID, user.id)
                                    }.apply()



                                val intent = Intent(this@LogActivity, HomeActivity::class.java)
                                startActivity(intent)
                                finish()

                            } else {

                                sharedPreference.edit().clear().apply()
                                Toast.makeText(this@LogActivity, "Username or Password wrong !!", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }

                        override fun onFailure(call: Call<User>, t: Throwable) {
                            Log.e("-----------call",t.toString())
                            Toast.makeText(this@LogActivity, "Connexion error!", Toast.LENGTH_SHORT).show()

                        }
                    })
                }
            }

            bInsc.setOnClickListener {
                val intent = Intent(this@LogActivity, InscritActivity::class.java)
                startActivity(intent)
                finish()
            }



        }

        private fun validation_form (email: String, password: String) :Boolean{



            if (TextUtils.isEmpty(email)){
                Toast.makeText(this@LogActivity,"Email ne peut pas etre vide",Toast.LENGTH_SHORT).show()
                return false;
            }

            if (TextUtils.isEmpty(password)){
                Toast.makeText(this@LogActivity,"password ne peut pas etre vide",Toast.LENGTH_SHORT).show()
                return false;
            }

            return true;
        }


    }