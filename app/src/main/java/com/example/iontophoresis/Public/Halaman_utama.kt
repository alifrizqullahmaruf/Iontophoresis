package com.example.iontophoresis.Public

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.iontophoresis.R
import com.example.iontophoresis.databinding.ActivityHalamanUtamaBinding

class Halaman_utama : AppCompatActivity() {
    private lateinit var binding: ActivityHalamanUtamaBinding
//    Tambahin logic untuk bagian faragmentnya
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHalamanUtamaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())


    binding.bottomNavigation.setOnItemSelectedListener { menuItem: MenuItem ->
        when (menuItem.itemId) {
            R.id.home_icon -> replaceFragment(HomeFragment())
            R.id.dosis_icon -> replaceFragment(DosisFragment())
            R.id.monitoring_icon -> replaceFragment(MonitoringFragment())
            R.id.profile_icon -> replaceFragment(ProfileFragment())
            else -> {
                // Tindakan jika ada item yang tidak dikenali
            }
        }
        true
    }

}




    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }

}