package com.example.sololearn.activity.model

import java.util.*

data class User (
    var id: Int,
    var login: String,
    var password: String,
    var name: String,
    var type: String,
    var age: Date
)