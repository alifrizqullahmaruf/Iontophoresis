package com.example.iontophoresis.Auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.iontophoresis.Adapter.PrefManager
import com.example.iontophoresis.Public.Halaman_utama
import com.example.iontophoresis.Public.HomeFragment
import com.example.iontophoresis.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val auth = FirebaseAuth.getInstance()
    private lateinit var prefManager: PrefManager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        prefManager = PrefManager.getInstance(this)
        setContentView(binding.root)
        // Check status loginnya
        checkLoginStatus()

        with(binding){
            // ========== Pergi ke register page ==========
            goToRegisterSignIn.setOnClickListener {
                startActivity(Intent(this@LoginActivity,RegisterUserActivity::class.java))
            }


            // =========== Pergi ke Home Page ==========
            buttonLogin.setOnClickListener {
                val email = binding.emailInputText.text.toString()
                val password = binding.passwordInputText.text.toString()

                // Check if email is not empty
                if (email.isEmpty()){
                    Toast.makeText(this@LoginActivity, "Input email", Toast.LENGTH_SHORT).show()
                }

                // Check if password is not empty
                if (password.isEmpty()){
                    Toast.makeText(this@LoginActivity, "Input password", Toast.LENGTH_SHORT).show()
                }

                // Memanggil firebase untuk masuk dengan menggunakaan akun yang sudah di buat
                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {task ->
                    if (task.isSuccessful){
                        saveLoginCredentials(email, password)
                        Toast.makeText(this@LoginActivity, "Login Success", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@LoginActivity, Halaman_utama::class.java))

                    }else{
                        Toast.makeText(this@LoginActivity, "Login Failed", Toast.LENGTH_SHORT).show()
                    }

                }

            }
        }
    }
    // save username dan password
    private fun saveLoginCredentials(username: String, password: String) {
        prefManager.saveUsername(username)
        prefManager.savePassword(password)
        prefManager.setLoggedIn(true)
    }

    // Check apa status login
    private fun checkLoginStatus() {
        val isLoggedIn = prefManager.isLoggedIn()

        if (isLoggedIn) {
                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, Halaman_utama::class.java))
                finish() // Finish the hosting activity
        } else {
            Toast.makeText(this, "Login gagal", Toast.LENGTH_SHORT).show()
        }

    }

}