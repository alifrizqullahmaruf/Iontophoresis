package com.example.iontophoresis

import android.content.Intent
import android.media.MediaPlayer.OnCompletionListener
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.iontophoresis.databinding.ActivityRegisterUserBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class RegisterUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterUserBinding

    // Firebase Authentication instance (initialized later in onViewCreated)
    lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mAuth = FirebaseAuth.getInstance()


        with(binding){
            buttonRegister.setOnClickListener {

                val email = binding.emailInputText.text.toString()
                val password = binding.passwordInputText.text.toString()

                // Check if email is not empty
                if (email.isEmpty()){
                    Toast.makeText(this@RegisterUserActivity, "Input email", Toast.LENGTH_SHORT).show()
                }

                // Check if password is not empty
                if (email.isEmpty()){
                    Toast.makeText(this@RegisterUserActivity, "Input password", Toast.LENGTH_SHORT).show()
                }

                // Create a new user with email and password
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    OnCompleteListener<AuthResult?>{ task->
                        if (task.isSuccessful){

                            val Name =binding.NameInputText.text.toString()
                            val nickName =binding.nickNameInputText.text.toString()

                            // Clear text in EditText fields after successful registration
                            binding.NameInputText.text?.clear()
                            binding.nickNameInputText.text?.clear()
                            binding.emailInputText.text?.clear()
                            binding.dateBirthInputText.text?.clear()
                            binding.passwordInputText.text?.clear()
                            binding.passwordInputVericicationText.text?.clear()

                            Toast.makeText(this@RegisterUserActivity, "Account Created", Toast.LENGTH_SHORT)
                                .show()
                        }else{
                            Toast.makeText(this@RegisterUserActivity, "Authentication failed", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                startActivity(Intent(this@RegisterUserActivity,LoginActivity::class.java))
            }

            // Icon google click listener
            iconSocialGoogle.setOnClickListener {
                // Open Google URL in a browser
                val google = "https://www.google.com/"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(google))
                startActivity(intent)
            }

            // Icon facebook click listener
            iconSocialFacebook.setOnClickListener {
                // Open Facebook URL in a browser
                val facebook = "https://id-id.facebook.com/"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(facebook))
                startActivity(intent)
            }
        }

    }
}