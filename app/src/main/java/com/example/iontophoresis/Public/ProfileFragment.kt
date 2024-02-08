package com.example.iontophoresis.Public

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iontophoresis.databinding.FragmentProfileBinding
import androidx.fragment.app.Fragment
import com.example.iontophoresis.Adapter.PrefManager
import com.example.iontophoresis.Auth.LoginActivity
import com.google.firebase.auth.FirebaseAuth

private lateinit var prefManager: PrefManager

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var prefManager: PrefManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        prefManager = PrefManager.getInstance(requireContext())

        return binding.root
        checkLoginStatus()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Setup views and listeners here using binding
        with(binding) {
            BtnLogOut.setOnClickListener {
                prefManager.setLoggedIn(false)
                FirebaseAuth.getInstance().signOut()
                startActivity(Intent(requireContext(), LoginActivity::class.java))
                prefManager.clear()
                requireActivity().finish()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun checkLoginStatus() {
        val isLoggedIn = prefManager.isLoggedIn()
        if (!isLoggedIn) {
            startActivity(Intent(requireContext(), LoginActivity::class.java))
            requireActivity().finish() // Finish the hosting activity
        }
    }
}
