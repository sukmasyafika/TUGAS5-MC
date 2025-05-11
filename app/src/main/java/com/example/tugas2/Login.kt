package com.example.tugas2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugas2.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth


class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnLogin.setOnClickListener {
            val email : String = binding.etEmail.text.toString().trim()
            val password : String = binding.etPassword.text.toString().trim()

            if (email.isEmpty()){
                binding.etEmail.error = "Input Email"
                binding.etEmail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.etEmail.error = "Invalid email"
                binding.etEmail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty() || password.length < 6) {
                binding.etPassword.error = "password harus 6 karakter"
                binding.etPassword.requestFocus()
                return@setOnClickListener
            }

            loginUser(email, password)

        }


        // text register
        binding.textRegister.setOnClickListener{
            startActivity(Intent(this, Register::class.java))
        }

        // text lupa password
        binding.txtForget.setOnClickListener{
            Intent(this, ForgetPassword::class.java).also {
                startActivity(it)
            }
        }

        //facebook
        binding.facebook.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/?locale2=id_ID&_rdr")))
        }

        //google
        binding.google.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW,Uri.parse("https://accounts.google.com/")))
        }

        //github
        binding.github.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW,Uri.parse("https://github.com/login")))
        }

    }

    private fun loginUser(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Intent(this, Main::class.java).also { intent ->
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    }
                } else {
                    Toast.makeText(this, "${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser != null) {
            Intent(this, Main::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }


}