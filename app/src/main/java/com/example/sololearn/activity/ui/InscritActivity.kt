package com.example.sololearn.activity.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.sololearn.R
import com.example.sololearn.activity.model.User
import com.example.sololearn.activity.utils.ApiInterface
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InscritActivity : AppCompatActivity() {

    lateinit var profilePic: ImageView
    private var selectedImageUri: Uri? = null

    lateinit var textName : TextInputEditText
    lateinit var txtLayoutName: TextInputLayout
    lateinit var textEmail : TextInputEditText
    lateinit var txtLayoutEmail: TextInputLayout
    lateinit var textPwd : TextInputEditText
    lateinit var txtLayoutPwd: TextInputLayout
    lateinit var textAge : TextInputEditText
    lateinit var txtLayoutAge: TextInputLayout
    lateinit var inscrit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscrit)

        textName = findViewById(R.id.txtFullNameAdd)
        txtLayoutName = findViewById(R.id.txtLayoutFullName)
        textEmail = findViewById(R.id.txtEmailAdd)
        txtLayoutEmail = findViewById(R.id.txtLayoutEmail)
        textPwd = findViewById(R.id.txtPwdAdd)
        txtLayoutPwd = findViewById(R.id.txtLayoutPwd)
        textAge = findViewById(R.id.txtAgeAdd)
        txtLayoutAge = findViewById(R.id.txtLayoutAge)
        inscrit = findViewById(R.id.btnInscit)
        profilePic = findViewById(R.id.profilePicAdd)

        profilePic.setOnClickListener {
            openGallery()
        }

        inscrit.setOnClickListener {
            AjoutUser()
        }


    }
    private fun openGallery() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.type = "image/*"
        startForResultOpenGallery.launch(intent)
    }

    private fun AjoutUser(){
        var type="USER"
        if (validate()){
            val apiInterface = ApiInterface.Inse()
            apiInterface.InsertU(textEmail.text.toString() , textPwd.text.toString(), textName.text.toString(), type  , textAge.text.toString()).enqueue(object :
                Callback<User> {

                override fun onResponse(call: Call<User>, response: Response<User>) {

                    val user = response.body()

                    if (user != null){
                        Toast.makeText(this@InscritActivity, "Ajout User Success", Toast.LENGTH_SHORT).show()

                        /*  val intent = Intent(this@ForgetActivity, CourseActivity::class.java)
                          startActivity(intent)
                          finish()*/

                    }else{
                        Toast.makeText(this@InscritActivity, "Ajout User", Toast.LENGTH_SHORT).show()
                    }

                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Toast.makeText(this@InscritActivity, "Connexion error!", Toast.LENGTH_SHORT).show()


                }

            })
        }
    }

    private fun validate(): Boolean {
        txtLayoutName.error = null
        txtLayoutEmail.error = null
        txtLayoutPwd.error = null
        txtLayoutAge.error = null

        if (textName.text!!.isEmpty()){
            txtLayoutName.error = "Please Enter Name"
            txtLayoutName.requestFocus()
            return false
        }
        if (textEmail.text!!.isEmpty()){
            txtLayoutEmail.error = "Please Enter Your Email"
            txtLayoutEmail.requestFocus()
            return false
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(textEmail.text.toString()).matches()){
            txtLayoutEmail.error = "Please Enter valide Email"
            txtLayoutEmail.requestFocus()
            return false
        }

        if (textPwd.text!!.isEmpty()){
            txtLayoutPwd.error = "Please Enter Password"
            txtLayoutPwd.requestFocus()
            return false
        }

        if (textAge.text!!.isEmpty()){
            txtLayoutAge.error = "Please Enter Age"
            txtLayoutAge.requestFocus()
            return false
        }

        return true
    }

    private val startForResultOpenGallery =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                selectedImageUri = result.data!!.data
                profilePic!!.setImageURI(selectedImageUri)
            }
        }
}