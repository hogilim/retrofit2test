package com.example.myapplication.find

import com.example.myapplication.register.UserLocation

data class FindSend(
    val sid : Long,
    val location : UserLocation,
    val title : String,
    val body : String,
    val time : String,
    val image : String // 전송타입?
)
