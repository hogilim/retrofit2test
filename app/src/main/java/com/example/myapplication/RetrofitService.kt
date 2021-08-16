package com.example.myapplication

import android.provider.ContactsContract
import retrofit2.Call
import retrofit2.http.*
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
}