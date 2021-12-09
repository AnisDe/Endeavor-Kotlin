package com.example.endeavorapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import com.example.endeavorapp.R
import com.example.endeavorapp.model.User
import com.example.endeavorapp.util.ApiInterface
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForgetActivity : AppCompatActivity() {



    lateinit var emailText : TextInputEditText
    lateinit var emailTextLayout : TextInputLayout
    lateinit var pwdOneText : TextInputEditText
    lateinit var pwdOneTextLayout : TextInputLayout
    lateinit var pwdTwoText : TextInputEditText
    lateinit var pwdTwoTextLayout : TextInputLayout
    lateinit var bChange : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget)

        emailText = findViewById(R.id.txtEmailForget)
        emailTextLayout = findViewById(R.id.LayoutEmailForget)
        pwdOneText = findViewById(R.id.txtPwdOneForget)
        pwdOneTextLayout = findViewById(R.id.LayoutPwdOneForget)
        pwdTwoText = findViewById(R.id.txtTwoPwdForget)
        pwdTwoTextLayout = findViewById(R.id.LayoutTwoPwdForget)
        bChange = findViewById(R.id.btnChangeForget)

        bChange.setOnClickListener {
            doForg();
        }


    }

    private fun doForg() {
        if(validate()){

            val intent = Intent(this@ForgetActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun validate(): Boolean {
        emailTextLayout.error = null
        pwdOneTextLayout.error = null
        pwdTwoTextLayout.error = null

        if (emailText.text!!.isEmpty()){
            emailTextLayout.error = "Please Enter Email"
            emailTextLayout.requestFocus()
            return false
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText.text.toString()).matches()){
            emailTextLayout.error = "Please Enter valide Email"
            emailTextLayout.requestFocus()
            return false
        }

        if (pwdOneText.text!!.isEmpty()){
            pwdOneTextLayout.error = "Please Enter Password"
            pwdOneTextLayout.requestFocus()
            return false
        }
        if (pwdTwoText.text!!.isEmpty()){
            pwdTwoTextLayout.error = "Please Enter Password"
            pwdTwoTextLayout.requestFocus()
            return false
        }

        if (!(pwdTwoText.text.toString()!!.equals(pwdOneText.text.toString()))){
            pwdTwoTextLayout.error = "Please Enter the Same Password"
            pwdTwoTextLayout.requestFocus()
            return false
        }

        return true
    }
}