package com.example.myapplication

import android.provider.ContactsContract
import com.example.myapplication.login.LoginResponse
import com.example.myapplication.login.LoginSend
import com.example.myapplication.register.RegisterResponse
import com.example.myapplication.register.UserLocation
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.Body
import retrofit2.http.Header
import java.net.URI
import java.net.URL
import java.net.URLDecoder

interface RetrofitService {
    @GET("getUlfptcaAlarmInfo?")
    fun getData(
        @Query("year") year : Int,
        @Query("pageNo") pageNo : Int,
        @Query("numOfRows") numOfRows : Int,
        @Query("returnType") returnType : String,
        @Query("serviceKey") serviceKey : String = URLDecoder.decode("UTF-8")
    ): Call<Data>
    @GET("")
    fun register(
        @Query("user_id") user_id : String,
        @Query("user_password") user_password : String,
        @Query("nickname") nickname : String,
        @Query("location") location : UserLocation
    ): Call<RegisterResponse>

    @Headers("content-type: application/json")
    @POST("login")
    fun login(
        @Body testing : LoginSend
    ):Call<LoginResponse>

    @GET("hogi")
    fun test(

    ):Call<Test>
}