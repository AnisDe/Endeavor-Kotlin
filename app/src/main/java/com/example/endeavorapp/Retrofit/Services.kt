package com.example.endeavorapp.Retrofit


import com.example.endeavorapp.model.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*






interface Services {


    @POST("register")
    fun register(@Body map: HashMap<String ,String>):Call<User>

    @POST("login")
    fun login(@Body map: HashMap<String ,String>):Call<User>

    @PATCH("addpost")
    fun AddPost(@Field("email") email: String, @Field("message") message: String): Call<User>


    companion object {



        fun create() : Services {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://10.0.2.2:3000/")
                .build()

            return retrofit.create(Services::class.java)
        }
    }





}