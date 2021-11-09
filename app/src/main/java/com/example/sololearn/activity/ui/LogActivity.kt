package com.example.sololearn.activity.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import com.example.sololearn.R
import com.example.sololearn.activity.model.User
import com.example.sololearn.activity.utils.ApiInterface
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogActivity : AppCompatActivity() {

  //  private lateinit var auth: FirebaseAuth

    lateinit var bLogin: Button
    lateinit var bForget : Button
    lateinit var bInsc : Button
    lateinit var textLogin : TextInputEditText
    lateinit var txtLayoutLogin: TextInputLayout
    lateinit var textPassword : TextInputEditText
    lateinit var txtLayoutPassword: TextInputLayout
    lateinit var progBar: CircularProgressIndicator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)

        bLogin = findViewById(R.id.btnLoginLog)
        bForget = findViewById(R.id.btnForgetLog)
        bInsc = findViewById(R.id.btnInscitLog)
        textLogin = findViewById(R.id.txtEmailLog)
        txtLayoutLogin = findViewById(R.id.LayoutEmailLog)
        textPassword = findViewById(R.id.txtPwdLog)
        txtLayoutPassword = findViewById(R.id.LayoutPwdLog)

        progBar = findViewById(R.id.progBar)
        progBar.visibility = View.INVISIBLE

        bLogin.setOnClickListener {
            doLogin();
        }
        bForget.setOnClickListener {
            doForget();
        }
        bInsc.setOnClickListener {
            val intent = Intent(this@LogActivity, InscritActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun doLogin(){
            if (validate()){
                val apiInterface = ApiInterface.create()
                progBar.visibility = View.VISIBLE

                window.setFlags(
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                )

                apiInterface.seConnecter(textLogin.text.toString(), textPassword.text.toString()).enqueue(object : Callback<User> {

                    override fun onResponse(call: Call<User>, response: Response<User>) {

                        val user = response.body()

                        if (user != null){
                            Toast.makeText(this@LogActivity, "Login Success", Toast.LENGTH_SHORT).show()

                            val intent = Intent(this@LogActivity, CourseActivity::class.java)
                            startActivity(intent)
                            finish()

                        }else{
                            Toast.makeText(this@LogActivity, "User not found", Toast.LENGTH_SHORT).show()
                        }

                        progBar.visibility = View.INVISIBLE
                        window.clearFlags( WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)




                    }

                    override fun onFailure(call: Call<User>, t: Throwable) {
                        Toast.makeText(this@LogActivity, "Connexion error!", Toast.LENGTH_SHORT).show()

                        progBar.visibility = View.INVISIBLE
                        window.clearFlags( WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                    }

                })

            }

    }

    private fun doForget(){
        val intent = Intent(this@LogActivity, ForgetActivity::class.java)
        startActivity(intent)
        finish()

    }

    private fun validate(): Boolean {
        txtLayoutLogin.error = null
        txtLayoutPassword.error = null

        if (textLogin.text!!.isEmpty()){
            txtLayoutLogin.error = "Please Enter Email"
            txtLayoutLogin.requestFocus()
            return false
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(textLogin.text.toString()).matches()){
            txtLayoutLogin.error = "Please Enter valide Email"
            txtLayoutLogin.requestFocus()
            return false
        }

        if (textPassword.text!!.isEmpty()){
            txtLayoutPassword.error = "Please Enter Email"
            txtLayoutPassword.requestFocus()
            return false
        }

        return true
    }
/*
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            reload();
        }
    }

    private fun reload() {
        TODO("Not yet implemented")
    }*/
}