package com.example.tugas2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class DetailProduk : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_produk)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val produk = intent.getParcelableExtra<ItemData>("produk")
        if (produk != null) {
            val gambar: ImageView = findViewById(R.id.imageView)
            val textJudul: TextView = findViewById(R.id.NamaProduk)
            val textDesk: TextView = findViewById(R.id.deskProduk)
            val textHarga: TextView = findViewById(R.id.hargaProduk)

            gambar.setImageResource(produk.gambar)
            textJudul.text = produk.nama
            textDesk.text = produk.desk
            textHarga.text = produk.harga.toString()
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