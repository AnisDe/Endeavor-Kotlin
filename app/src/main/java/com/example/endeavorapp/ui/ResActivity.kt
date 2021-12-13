package com.example.endeavorapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.endeavorapp.R

class ResActivity : AppCompatActivity() {
    lateinit var congo: TextView
    lateinit var Score: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_res)

        congo = findViewById(R.id.congo)
        Score = findViewById(R.id.Score)
        button = findViewById(R.id.button)
        //      window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        val userName = intent.getStringExtra(setData.name)
        val score = intent.getStringExtra(setData.score)
        val totalQuestion = intent.getStringExtra("total size")
        val nameC =intent.getStringExtra("NAME").toString()

        congo.text = "Congratulations ${userName} !! FOR cour OF ${nameC}"
        Score.text = "${score} / ${totalQuestion}"
        button.setOnClickListener {
            startActivity(Intent(this, MenuLevelActivity::class.java))
            finish()
        }
    }
}