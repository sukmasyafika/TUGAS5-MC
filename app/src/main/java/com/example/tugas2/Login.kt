package com.example.tugas2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugas2.databinding.ActivityLoginBinding


const val EXTRA_MESSAGE = "com.example.projectsharemessage.MESSAGE"

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Btn Login
        binding.btnLogin.setOnClickListener{
            startActivity(Intent(this, Main::class.java))
        }

        // text register
        binding.textRegister.setOnClickListener{
            startActivity(Intent(this, Register::class.java))
        }

        // text lupa password
        binding.txtForget.setOnClickListener{
            startActivity(Intent(this, ForgetPassword::class.java))
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

        //kirim username / email
        binding.btnLogin.setOnClickListener {
            val editText = findViewById<EditText>(R.id.etEmail)
            val message = editText.text.toString()
            val intent = Intent(this, Main::class.java). apply {
                putExtra(EXTRA_MESSAGE, message)
            }
            startActivity(intent)
        }
        
    }
}