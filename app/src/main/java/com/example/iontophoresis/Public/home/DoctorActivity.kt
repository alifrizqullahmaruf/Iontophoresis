package com.example.iontophoresis.Public.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.iontophoresis.Adapter.AdapterDoctorActivity
import com.example.iontophoresis.Model.Doctor
import com.example.iontophoresis.Public.Halaman_utama
import com.example.iontophoresis.databinding.ActivityDoctorBinding
import com.google.firebase.firestore.FirebaseFirestore

class DoctorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDoctorBinding
    private lateinit var firebaseFirestore:FirebaseFirestore
    private val DoctorList: MutableLiveData<List<Doctor>> by lazy {
        MutableLiveData<List<Doctor>>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseFirestore= FirebaseFirestore.getInstance()
        binding.btnBack.setOnClickListener {
            val intent= Intent(this, Halaman_utama::class.java)
            startActivity(intent)
            finish()
        }
        observeDoctor()
        observeDoctorChange()
    }

    private fun observeDoctor(){
        DoctorList.observe(this){ Doctors ->
            val adapter = AdapterDoctorActivity(Doctors){
                val intent=Intent(this, DetailsTreatmentActivity::class.java)
                intent.putExtra("Doctor",it)
                startActivity(intent)
            }
            binding.rvHospital.adapter = adapter
            binding.rvHospital.layoutManager= LinearLayoutManager(this)
        }
    }

    private fun observeDoctorChange() {
        firebaseFirestore.collection("Doctors").addSnapshotListener{ snapshots, error ->
            // jika dia terjadi error maka dia akan memunculkan log
            if(error != null){
                Log.e("testttt", "Error listening for movies changes: ", error)
                return@addSnapshotListener
            }
            // jika gak error maka akan langsung ke sini
            val doctor = snapshots?.toObjects(Doctor::class.java)
            if (doctor != null) {
                DoctorList.postValue(doctor)
            }
        }
    }
}