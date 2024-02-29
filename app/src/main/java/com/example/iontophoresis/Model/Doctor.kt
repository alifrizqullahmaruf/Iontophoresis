package com.example.iontophoresis.Model

import java.io.Serializable

data class Doctor(
    val Name:String="",
    val Specialist:String="",
    val Location:String="",
    val Rating:Double=0.0,
    val Reviewers:Int=0,
    val Image:String=""
):Serializable
