package com.example.endeavorapp.model

import java.util.*

data class User (
    var id: String,
    var email: String,
    var password: String,
    var name: String,
    var type: String,
    var age: Int,
    var followers: String,
    var post : Int
)
