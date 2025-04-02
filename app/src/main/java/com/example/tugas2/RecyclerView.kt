package com.example.tugas2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas2.databinding.ActivityRecyclerViewBinding


class RecyclerView : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewBinding

    private lateinit var produkRecyclerView: RecyclerView
    private lateinit var produkAdapter: MyAdapter
    private lateinit var listProduk: ArrayList<ItemData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Btn back
        binding.btnback.setOnClickListener{
            startActivity(Intent(this, Main::class.java))
        }

        produkRecyclerView = findViewById(R.id.produkRV)
        listProduk = ArrayList()

        listProduk.add(ItemData(R.drawable.polaroid, "Cetak Polaroid", "Cetak foto polaroid dengan kualitas terbaik!"))
        listProduk.add(ItemData(R.drawable.undangan1, "Undangan Custom", "Buat undangan unik sesuai keinginanmu!"))
        listProduk.add(ItemData(R.drawable.undangan2, "Undangan Website", "Undangan digital, praktis & modern!"))
        listProduk.add(ItemData(R.drawable.kalender, "Kalender Custom", "Desain kalender sendiri untuk hadiah atau promosi!"))
        listProduk.add(ItemData(R.drawable.brosur, "Brosur Promosi", "Buat brosur bisnis dengan desain profesional!"))
        listProduk.add(ItemData(R.drawable.spanduk, "Spanduk", "Cetak spanduk berkualitas untuk berbagai keperluan!"))
        listProduk.add(ItemData(R.drawable.stiker, "Stiker Custom", "Cetak stiker keren untuk branding atau hobi!"))
        listProduk.add(ItemData(R.drawable.plastik, "Plastik Custom", "Kemasan plastik dengan desain logo sendiri!"))
        listProduk.add(ItemData(R.drawable.id_card, "ID Card", "Cetak kartu identitas untuk kantor, event, atau komunitas!"))

        produkRecyclerView.layoutManager = LinearLayoutManager(this )
        produkRecyclerView.setHasFixedSize(true)
        produkAdapter = MyAdapter(listProduk)
        produkRecyclerView.adapter = produkAdapter

    }
}