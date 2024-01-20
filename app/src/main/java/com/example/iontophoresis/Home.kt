package com.example.iontophoresis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.iontophoresis.Adapter.PrefManager
import com.example.iontophoresis.Auth.LoginActivity
import com.example.iontophoresis.databinding.ActivityHomeBinding
import com.google.firebase.auth.FirebaseAuth

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var prefManager: PrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefManager = PrefManager.getInstance(this)
        checkLoginStatus()


        with(binding){
            BtnLogOut.setOnClickListener {
                prefManager.setLoggedIn(false)
                FirebaseAuth.getInstance().signOut()
                startActivity(Intent(this@Home, LoginActivity::class.java))
                prefManager.clear()
                finish()
            }
        }
    }
    fun checkLoginStatus() {
        val isLoggedIn = prefManager.isLoggedIn()
        if (!isLoggedIn) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}