package com.example.iontophoresis.Public.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iontophoresis.databinding.FragmentHomeBinding
import com.google.firebase.firestore.FirebaseFirestore

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var firebaseFirestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(layoutInflater,container,false)
        firebaseFirestore=FirebaseFirestore.getInstance()
        with(binding){
            hospital.setOnClickListener {
                val intent=Intent(requireContext(), HospitalActivity::class.java)
                startActivity(intent)
            }

            

            doctor.setOnClickListener {
                val intent=Intent(requireContext(), DoctorActivity::class.java)
                startActivity(intent)
            }

        }
        return binding.root
    }

}