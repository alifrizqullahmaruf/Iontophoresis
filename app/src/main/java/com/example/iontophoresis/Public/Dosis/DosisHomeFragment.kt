package com.example.iontophoresis.Public.Dosis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.example.iontophoresis.R
import com.example.iontophoresis.databinding.FragmentDosisHomeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [DosisHomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DosisHomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentDosisHomeBinding

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