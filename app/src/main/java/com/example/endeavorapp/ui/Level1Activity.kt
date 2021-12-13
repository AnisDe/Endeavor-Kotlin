package com.example.endeavorapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.example.endeavorapp.R

class Level1Activity : AppCompatActivity() {
    lateinit var rbGroup : RadioGroup
    lateinit var rb1: RadioButton
    lateinit var rb2: RadioButton
    lateinit var rb3: RadioButton
    lateinit var rb4: RadioButton
    lateinit var buttonConfNext: Button
    lateinit var txtViewQuestion :TextView
    lateinit var txtViewScore:TextView
    lateinit var txtViewQuestionCount :TextView
    lateinit var txtViewCountDown :TextView
    lateinit var txtViewCorrect :TextView
    lateinit var txtViewWrong :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level1)

        setupUI();
    }

    private fun setupUI() {
        txtViewQuestion =findViewById(R.id.textViewQ)
        txtViewScore =findViewById(R.id.txtScore)
        txtViewQuestionCount =findViewById(R.id.txtTotalQuestions)
        txtViewCountDown =findViewById(R.id.textViewQ)
        txtViewWrong =findViewById(R.id.txtWrong)
        txtViewCorrect =findViewById(R.id.txtCorrect)

        buttonConfNext =findViewById(R.id.buttonNLevel)
        rbGroup =findViewById(R.id.radio_group)
        rb1 =findViewById(R.id.radio_botton1)
        rb2 =findViewById(R.id.radio_botton2)
        rb3 =findViewById(R.id.radio_botton3)
        rb4 =findViewById(R.id.radio_botton4)

    }
}