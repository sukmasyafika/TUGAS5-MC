package com.example.tugas2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas2.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class Main : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pesan = intent.getStringExtra(EXTRA_MESSAGE)

        binding.textUsername.text = "Hallo $pesan"

        binding.btnRV.setOnClickListener {
            startActivity(Intent(this, ProdukRecyclerView::class.java))
        }

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    Toast.makeText( this, "Hone click", Toast.LENGTH_SHORT).show()
                    true }
                R.id.navigation_search -> {
                    Toast.makeText( this, "Search click", Toast.LENGTH_SHORT).show()
                    true }
                R.id.navigation_notifications->{
                    Toast.makeText( this,  "Notification click", Toast.LENGTH_SHORT)
                            .show()
                    true }
                else -> false
            }
        }
    }

}