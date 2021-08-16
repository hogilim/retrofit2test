package com.example.myapplication.unit

data class UnitRequest(
    val dogname : String,
    val doggender : String,
    val dogage : Int,
    val body : String,
    val image : String // 전송 형식?
)
