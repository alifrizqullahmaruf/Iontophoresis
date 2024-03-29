package com.example.iontophoresis.Public

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iontophoresis.databinding.FragmentDosisBinding
import androidx.fragment.app.Fragment

class DosisFragment : Fragment() {
    private var _binding: FragmentDosisBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDosisBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Setup views and listeners here using binding
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
