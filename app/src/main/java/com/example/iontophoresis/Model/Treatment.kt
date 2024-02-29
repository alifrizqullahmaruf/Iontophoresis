package com.example.iontophoresis.Model

import java.io.Serializable
import java.util.Date

data class Treatment(
    val PasienName:String="",
    val DoctorNamme:String="",
    val Date:Date= Date(),
    val SpecializeDoctor:String="",
    val Hospital:String="",
    val Image:String="",
    val About:String="",
    val Gel:String="",
    val Muatan:Int=0,
    val Duration:String="",
    val Status:String=""
):Serializable
