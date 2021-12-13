package com.example.endeavorapp.model

import java.util.*

data class User (
    var id: String,
    var login: String,
    var password: String,
    var name: String,
    var type: String,
    var age: Date,
    var followers: String,
    var post : String
)
