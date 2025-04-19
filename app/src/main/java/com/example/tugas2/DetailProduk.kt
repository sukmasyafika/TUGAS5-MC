package com.example.tugas2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailProduk : AppCompatActivity() {
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
    }
}