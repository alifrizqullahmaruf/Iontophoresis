package com.example.iontophoresis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.iontophoresis.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            // Pergi ke register page
            goToRegisterSignIn.setOnClickListener {
                startActivity(Intent(this@LoginActivity, RegisterUserActivity::class.java))
            }

            // Pergi ke Home Page
            buttonLogin.setOnClickListener {
                val email = binding.emailInputText.text.toString()
                val password = binding.passwordInputText.text.toString()

                // Check if email is not empty
                if (email.isEmpty()){
                    Toast.makeText(this@LoginActivity, "Input email", Toast.LENGTH_SHORT).show()
                }

                // Check if password is not empty
                if (email.isEmpty()){
                    Toast.makeText(this@LoginActivity, "Input password", Toast.LENGTH_SHORT).show()
                }

                // Memanggil firebase untuk masuk dengan menggunakaan akun yang sudah di buat
                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {task ->
                    if (task.isSuccessful){
                        Toast.makeText(this@LoginActivity, "Login Success", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@LoginActivity, Home::class.java))

                    }else{
                        Toast.makeText(this@LoginActivity, "Login Failed", Toast.LENGTH_SHORT).show()
                    }

                }

            }
        }
    }
}