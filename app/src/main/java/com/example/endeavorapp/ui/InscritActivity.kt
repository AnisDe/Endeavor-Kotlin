package com.example.endeavorapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import com.example.endeavorapp.R
import com.example.endeavorapp.Retrofit.*
import com.google.android.material.textfield.TextInputEditText
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

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





        val retrofit =  RetrofitClient.getInstance()
        services = retrofit.create(Services::class.java)


        register_btn.setOnClickListener{

            if (register(Email.text.toString() , Password.text.toString(),Age.text.toString().toInt(), FullName.text.toString()))
                intent = Intent(this@InscritActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }





    }

    private fun register(Email: String, Password: String , Age: Int, FullName:String ) :Boolean {

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

        compositeDisposable.addAll(services.register(Email,FullName,Age,Password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {result -> Toast.makeText(this@InscritActivity ,""+result,Toast.LENGTH_SHORT).show()}

        )
        return true;
    }




}
