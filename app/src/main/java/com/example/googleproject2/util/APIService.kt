package com.example.googleproject3

import com.example.googleproject2.model.LoginModel
import retrofit2.Call
import retrofit2.http.*

interface APIService {

    @GET("C_Login/index_post")
    fun Login(@Query("username") username: String, @Query("password") password: String): Call<LoginModel>

    @GET("C_CRUD/index_get")
    fun Data(): Call<LoginModel>
}
