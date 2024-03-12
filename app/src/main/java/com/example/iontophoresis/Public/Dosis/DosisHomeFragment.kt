package com.example.iontophoresis.Public.Dosis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.example.iontophoresis.R
import com.example.iontophoresis.databinding.FragmentDosisHomeBinding
import com.google.firebase.database.FirebaseDatabase

class DosisHomeFragment : Fragment() {
    private lateinit var binding: FragmentDosisHomeBinding
    private lateinit var firebaseDatabase: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentDosisHomeBinding.inflate(layoutInflater,container,false)

        return binding.root
    }


}