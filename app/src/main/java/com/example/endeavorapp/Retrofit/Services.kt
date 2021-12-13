package com.example.endeavorapp.Retrofit


import com.example.endeavorapp.model.User
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*



interface Services {

    @POST("register")
    @FormUrlEncoded
    fun register(@Field("email") email: String ,
                    @Field("name") name: String,
                    @Field("age") age: Int,
                    @Field("password") password: String):Observable<String>

    @POST("login")
    @FormUrlEncoded
    fun login(@Field("email") email: String ,
                    @Field("password") password: String):Observable<String>

    @PATCH("addpost")
    @FormUrlEncoded
    fun AddPost(@Field("email") email: String, @Field("message") message: String): Call<User>







}