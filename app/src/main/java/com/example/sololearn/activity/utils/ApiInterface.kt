package com.example.sololearn.activity.utils

import com.example.sololearn.activity.model.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

import retrofit2.http.POST
import retrofit2.http.Query


interface ApiInterface {

    @POST("login")
    fun seConnecter(@Query("log") login: String, @Query("pwd") password: String): Call<User>

    @POST("updatePwd")
    fun ChangePWD(@Query("pwd") password: String, @Query("log") login : String): Call<User>

    @POST("insertUser")
    fun InsertU(@Query("log") login: String, @Query("pwd") password: String, @Query("name") name: String, @Query("type") type: String, @Query("age") age: String): Call<User>


    companion object {

        var BASE_URL = "http://192.168.1.102:5000/"

        fun change() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ApiInterface::class.java)
        }

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ApiInterface::class.java)
        }
        fun Inse() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ApiInterface::class.java)
        }



    }




}