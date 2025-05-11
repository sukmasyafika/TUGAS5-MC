package com.example.tugas2

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugas2.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_register)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnRegister.setOnClickListener {
            val email : String = binding.etEmail.text.toString().trim()
            val username : String = binding.etNama.text.toString().trim()
            val password : String = binding.etPassword.text.toString().trim()
            val confirmPassword : String = binding.etConfirmPassword.text.toString().trim()

            if(email.isEmpty()) {
                binding.etEmail.error = "Input Email"
                binding.etEmail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.etEmail.error = "Invalid email"
                binding.etEmail.requestFocus()
                return@setOnClickListener
            }

            if(username.isEmpty()) {
                binding.etNama.error = "Input Username"
                binding.etNama.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty() || password.length < 6 ) {
                binding.etPassword.error = "Password Minimal berisi 6 karakter"
                binding.etPassword.requestFocus()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                binding.etConfirmPassword.error = "Password tidak Sesuai"
                binding.etConfirmPassword.requestFocus()
                return@setOnClickListener
            }

            registerUser(email, password)

        }

        // text Login
        binding.txtLogin.setOnClickListener{
            startActivity(Intent(this, Login::class.java))
        }

    }

    private fun registerUser(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Intent(this, Login::class.java).also { intent ->
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    }
                } else {
                    Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
    }


    override fun onStart() {
        super.onStart()
        if(firebaseAuth.currentUser != null) {
            Intent(this, Login::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }
}