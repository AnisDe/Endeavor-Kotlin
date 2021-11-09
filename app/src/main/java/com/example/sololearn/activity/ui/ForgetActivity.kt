package com.example.sololearn.activity.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.sololearn.R
import com.example.sololearn.activity.model.User
import com.example.sololearn.activity.utils.ApiInterface
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForgetActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

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
           // val builder = AlertDialog.Builder(this)
         /*   builder.setTitle("Config New Password")
        //    val view = LayoutInflater.from(R.layout.dialog_forget_pwd,null)  //.inflate(R.layout.dialog_forget_pwd, null)
           builder.show()*/

            val apiInterface = ApiInterface.change()
            apiInterface.ChangePWD(pwdOneText.text.toString() , emailText.text.toString()).enqueue(object :
                Callback<User> {

                override fun onResponse(call: Call<User>, response: Response<User>) {

                    val user = response.body()

                    if (user != null){
                        Toast.makeText(this@ForgetActivity, "Change Password Success", Toast.LENGTH_SHORT).show()

                      /*  val intent = Intent(this@ForgetActivity, CourseActivity::class.java)
                        startActivity(intent)
                        finish()*/

                    }else{
                        Toast.makeText(this@ForgetActivity, "User not found", Toast.LENGTH_SHORT).show()
                    }

                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Toast.makeText(this@ForgetActivity, "Connexion error!", Toast.LENGTH_SHORT).show()


                }

            })
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


