package com.example.iontophoresis.Public.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.iontophoresis.Model.Doctor
import com.example.iontophoresis.R
import com.example.iontophoresis.databinding.ActivityDetailsTreatmentBinding

class DetailsTreatmentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsTreatmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailsTreatmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val doctor=intent.getSerializableExtra("Doctor") as Doctor

        with(binding){
            doctorName.text=doctor.Name
            location.text=doctor.Location
            specialist.text=doctor.Specialist
            Glide.with(this@DetailsTreatmentActivity).load(doctor.Image).centerCrop().into(image)
        }
    }
}