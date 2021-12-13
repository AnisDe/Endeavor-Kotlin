package com.example.endeavorapp.data

data class Questions(
    var id:Int,
    val question: String,

    var option_one:String,
    var option_tw0:String,
    var option_three:String,
    var option_four:String,
    var correct_ans:Int
)
