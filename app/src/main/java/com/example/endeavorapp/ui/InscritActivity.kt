package com.example.endeavorapp.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.endeavorapp.R
import com.example.endeavorapp.Retrofit.*
import com.example.endeavorapp.model.User
import com.google.android.material.textfield.TextInputEditText
import io.reactivex.disposables.CompositeDisposable

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InscritActivity : AppCompatActivity() {


    lateinit var services: Services
    internal var compositeDisposable = CompositeDisposable()

    override fun onStop() {
        compositeDisposable.clear()
        super.onStop()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscrit)

        lateinit var register_btn: Button
        lateinit var Email : TextInputEditText
        lateinit var Password : TextInputEditText
        lateinit var Age : TextInputEditText
        lateinit var FullName : TextInputEditText


        register_btn = findViewById(R.id.btnInscit)
        Email = findViewById(R.id.txtEmailAdd)
        Age = findViewById(R.id.txtAgeAdd)
        Password = findViewById(R.id.txtPwdAdd)
        FullName = findViewById(R.id.txtFullNameAdd)








        register_btn.setOnClickListener{
            var services = Services.create()
            var x = {
                Email.text.toString()
                Password.text.toString()
                Age.text.toString().toInt()
                FullName.text.toString()
            }
        val validation_form =  validation_form(Email.text.toString() , Password.text.toString() ,Age.text.toString().toInt() , FullName.text.toString())
        if (validation_form) {



            val map: HashMap<String, String> = HashMap()
            map["email"] = Email.text.toString()
            map["password"] = Password.text.toString()
            map["name"] = FullName.text.toString()
            map["age"] = Age.text.toString()
            services.register(map).enqueue(object : Callback<User> {
                override fun onResponse(
                    call: Call<User>, response:
                    Response<User>
                ) {

                    val user = response.body()

                    if (user != null) {
                        val sharedPreference =
                            getSharedPreferences("userInfo", Context.MODE_PRIVATE)
                        Log.e("//////////////////user ", response.body().toString())
                        sharedPreference.edit().clear().apply()
                        sharedPreference.edit().apply {
                            putBoolean("isConnected", true)
                            putString("Email", user.email)
                            putString("Fullname", user.name)
                            putInt("Age", user.age)
                            putString("Password", user.password)
                            putString("ID", user.id)
                        }.apply()

                        Log.e("//////////////////user ", response.body().toString())
                        val intent = Intent(this@InscritActivity, HomeActivity::class.java)
                        startActivity(intent)
                        finish()

                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Toast.makeText(this@InscritActivity, "Connexion error!", Toast.LENGTH_SHORT)
                        .show()

                }
            })
        }
        }





    }

    private fun validation_form(Email: String, Password: String , Age: Int, FullName:String ) :Boolean {

        if (TextUtils.isEmpty(Email)){
            Toast.makeText(this@InscritActivity,"Email ne peut pas etre vide",Toast.LENGTH_SHORT).show()
            return false ;
        }

        if (TextUtils.isEmpty(Password)){
            Toast.makeText(this@InscritActivity,"password ne peut pas etre vide",Toast.LENGTH_SHORT).show()
            return false ;
        }

        if (TextUtils.isEmpty(Age.toString())){
            Toast.makeText(this@InscritActivity,"age ne peut pas etre vide",Toast.LENGTH_SHORT).show()
            return false;
        }

        if (TextUtils.isEmpty(FullName)){
            Toast.makeText(this@InscritActivity,"nom ne peut pas etre vide",Toast.LENGTH_SHORT).show()
            return false ;
        }



        return true;
    }




}
