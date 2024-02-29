package com.example.iontophoresis.Public.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.iontophoresis.Adapter.AdapterHospitalActivity
import com.example.iontophoresis.Model.Hospital
import com.example.iontophoresis.Public.Halaman_utama
import com.example.iontophoresis.R
import com.example.iontophoresis.databinding.ActivityHospitalBinding
import com.google.android.gms.auth.api.signin.internal.Storage
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

class HospitalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHospitalBinding
    private lateinit var firestore: FirebaseFirestore
    private val HospitalList: MutableLiveData<List<Hospital>> by lazy {
        MutableLiveData<List<Hospital>>()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHospitalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firestore= FirebaseFirestore.getInstance()
        binding.btnBack.setOnClickListener {
            val intent=Intent(this,Halaman_utama::class.java)
            startActivity(intent)
            finish()
        }
        observeHospital()
        observeHospitalChange()
    }
    private fun observeHospital(){
        HospitalList.observe(this){ movies ->
            val adapter = AdapterHospitalActivity(movies)
            binding.rvHospital.adapter = adapter
            binding.rvHospital.layoutManager=LinearLayoutManager(this)
        }
    }

    private fun observeHospitalChange() {
        firestore.collection("Hospital").addSnapshotListener{ snapshots, error ->
            // jika dia terjadi error maka dia akan memunculkan log
            if(error != null){
                Log.e("testttt", "Error listening for movies changes: ", error)
                return@addSnapshotListener
            }
            // jika gak error maka akan langsung ke sini
            val hospital = snapshots?.toObjects(Hospital::class.java)
            if (hospital != null) {
                HospitalList.postValue(hospital)
            }
        }
    }
}