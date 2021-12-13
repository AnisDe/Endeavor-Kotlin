package com.example.endeavorapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import com.example.endeavorapp.R

const val LEVEL ="LEVEL"

class MenuLevelActivity : AppCompatActivity() {
    lateinit var bLevel1 :Button
    lateinit var bLevel2 :Button
    lateinit var bLevel3 :Button
    lateinit var bLevel4 :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_level)
        bLevel1 =findViewById(R.id.ButtonLevel1)
        bLevel2 =findViewById(R.id.ButtonLevel2)
        bLevel3 =findViewById(R.id.ButtonLevel3)
        bLevel4 =findViewById(R.id.ButtonLevel4)

        val toolbar: Toolbar = findViewById(R.id.app_bar2)

        toolbar.setNavigationIcon(R.drawable.ic_back)
        setSupportActionBar(toolbar)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        bLevel1.setOnClickListener {
            GoLevel1()
        }
        bLevel2.setOnClickListener {
            GoLevel2()
        }
        bLevel3.setOnClickListener {
            GoLevel3()
        }
        bLevel4.setOnClickListener {
            GoLevel4()
        }

    }
    private fun GoLevel1(){

        val intent = Intent(this@MenuLevelActivity, QuestionActivity::class.java)
        intent.apply {
            putExtra(LEVEL, 1)
            putExtra("NAME",intent.getStringExtra("NAME").toString())
        }
        startActivity(intent)
        finish()
    }
    private fun GoLevel2(){
        val intent = Intent(this@MenuLevelActivity, QuestionActivity::class.java)
        intent.apply {
            putExtra(LEVEL, 2)
        }
        startActivity(intent)
        finish()

    }
    private fun GoLevel3(){
        val intent = Intent(this@MenuLevelActivity, QuestionActivity::class.java)
        intent.apply {
            putExtra(LEVEL, 3)
        }
        startActivity(intent)
        finish()

    }
    private fun GoLevel4(){
        val intent = Intent(this@MenuLevelActivity, QuestionActivity::class.java)
        intent.apply {
            putExtra(LEVEL, 4)
        }
        startActivity(intent)
        finish()

    }
}


