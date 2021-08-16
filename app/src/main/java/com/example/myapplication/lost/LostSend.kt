package com.example.myapplication.lost

import com.example.myapplication.register.UserLocation

data class LostSend(
    val sid : Long,
    val location : UserLocation,
    val title : String,
    val dogname : String,
    val doggender : String,
    val dogage : Int,
    val body : String,
    val time : String,
    val image : String
)
