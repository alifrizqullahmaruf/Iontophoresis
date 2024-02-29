package com.example.iontophoresis.Public.Dosis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.iontophoresis.databinding.FragmentDosisBinding
import androidx.fragment.app.Fragment
import com.example.iontophoresis.Adapter.TabAdapter
import com.example.iontophoresis.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DosisFragment : Fragment() {
    private var _binding: FragmentDosisBinding? = null
    private val binding get() = _binding!!
    companion object{
        private val title= intArrayOf(
            R.string.home,
            R.string.history
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDosisBinding.inflate(inflater, container, false)
        with(_binding!!){
            val sectionPager = TabAdapter(requireActivity() as AppCompatActivity)
            viewPager.adapter=sectionPager
            TabLayoutMediator(tabLayout,viewPager){
                    tab,position->tab.text=resources.getString(title[position])
            }.attach()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
