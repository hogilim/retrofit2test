package com.example.myapplication

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitClient {
    private var instance : Retrofit? = null
    private val gson = GsonBuilder().setLenient().create()

    fun getInstnace() : Retrofit {
        if(instance == null){
            instance = Retrofit.Builder()
                .baseUrl("http://localhost:8080/test/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                //.addConverterFactory(ScalarsConverterFactory.create())
                .build()
        }
        return instance!!
    }
}