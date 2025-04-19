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


class ProdukRecyclerView : AppCompatActivity() {
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
        binding.btnback.setOnClickListener {
            startActivity(Intent(this, Main::class.java))
        }

        produkRecyclerView = findViewById(R.id.produkRV)
        listProduk = ArrayList()

        listProduk.add(
            ItemData(
                R.drawable.polaroid,
                "Cetak Polaroid",
                "Cetak foto polaroid dengan kualitas terbaik menggunakan kertas premium dan tinta tahan lama. " +
                        "Cocok untuk hadiah, hiasan kamar, atau kenang-kenangan spesial.\n\n" +
                        "Kami menyediakan berbagai ukuran dan desain frame polaroid yang bisa kamu pilih sesuai selera. " +
                        "Tersedia juga layanan cetak instan hanya dalam hitungan menit.\n\n" +
                        "Kamu bisa upload langsung dari galeri atau Instagram, lalu kami cetak dan kirim ke rumahmu dengan aman dan cepat.",
                1000
            )
        )

        listProduk.add(
            ItemData(
                R.drawable.undangan1,
                "Undangan Custom",
                "Buat undangan sesuai kepribadianmu! Mulai dari pernikahan, ulang tahun, hingga acara resmi — semua bisa kamu desain sendiri.\n\n" +
                        "Kami menyediakan template unik dan juga layanan desain profesional jika kamu butuh bantuan visual. " +
                        "Material kertas yang digunakan juga bisa dipilih: glossy, doff, atau eco-friendly.\n\n" +
                        "Dapatkan harga spesial untuk pemesanan dalam jumlah besar. Kirim desainmu, dan undangan impianmu siap dicetak!",
                120000
            )
        )

        listProduk.add(
            ItemData(
                R.drawable.undangan2,
                "Undangan Website",
                "Undangan digital kini jadi tren! Praktis, modern, dan bisa dibagikan lewat WhatsApp, Instagram, hingga email. " +
                        "Dilengkapi dengan galeri foto, peta lokasi, dan form RSVP.\n\n" +
                        "Kami menyediakan desain yang responsif dan estetik, bisa dibuka di semua perangkat tanpa repot. " +
                        "Kamu juga bisa request lagu latar, animasi, dan domain pribadi.\n\n" +
                        "Solusi terbaik untuk acara pernikahan, ulang tahun, atau event lainnya. Tinggal kirim link, semua orang bisa lihat undanganmu!",
                500000
            )
        )

        listProduk.add(
            ItemData(
                R.drawable.kalender,
                "Kalender Custom",
                "Desain kalender pribadi dengan foto-foto kenanganmu! Bisa dijadikan hadiah akhir tahun atau alat promosi bisnis.\n\n" +
                        "Tersedia model dinding, meja, atau kalender poster dengan berbagai pilihan layout bulan dan tanggal. " +
                        "Kami juga menerima permintaan khusus seperti penambahan tanggal penting pribadi.\n\n" +
                        "Cocok untuk keluarga, kantor, atau organisasi. Dicetak dengan warna tajam dan tahan lama.",
                150000
            )
        )

        listProduk.add(
            ItemData(
                R.drawable.brosur,
                "Brosur Promosi",
                "Brosur adalah alat promosi yang efektif untuk bisnis kamu. Kami cetak dengan kualitas terbaik dan desain profesional.\n\n" +
                        "Bisa dipilih ukuran A4, A5, atau custom sesuai kebutuhan. Kami juga menerima desain bolak-balik dan lipat tiga.\n\n" +
                        "Cocok untuk promosi event, produk baru, atau kampanye sosial. Dijamin menarik perhatian pelanggan!",
                220000
            )
        )

        listProduk.add(
            ItemData(
                R.drawable.spanduk,
                "Spanduk",
                "Cetak spanduk untuk segala keperluan: acara, toko, promosi, kampanye, dan banyak lagi! " +
                        "Bahan kuat dan tahan cuaca.\n\n" +
                        "Kami melayani ukuran kecil hingga besar dengan desain bebas custom. Bisa tambah logo, foto, atau QR Code.\n\n" +
                        "Langsung cetak dan kirim ke alamatmu. Cepat, praktis, dan hasil memuaskan.",
                320000
            )
        )

        listProduk.add(
            ItemData(
                R.drawable.stiker,
                "Stiker Custom",
                "Cetak stiker untuk branding, hadiah, hobi, atau dekorasi. Kami sediakan berbagai jenis stiker: vinyl, transparan, hologram, dan lainnya.\n\n" +
                        "Bisa potong bentuk bebas sesuai desain. Tahan air dan tidak mudah luntur, cocok ditempel di botol, motor, laptop, dll.\n\n" +
                        "Harga terjangkau, kualitas tetap nomor satu. Cocok untuk personal atau bisnis UMKM.",
                20000
            )
        )

        listProduk.add(
            ItemData(
                R.drawable.plastik,
                "Plastik Custom",
                "Buat kemasan plastik dengan desain logomu sendiri. Cocok untuk makanan, fashion, dan produk retail lainnya.\n\n" +
                        "Kami menyediakan berbagai ukuran dan ketebalan plastik. Bisa pilih model ziplock, handle, atau press.\n\n" +
                        "Branding jadi lebih profesional dengan kemasan custom. Pesan sekarang dan tampil beda!",
                50000
            )
        )

        listProduk.add(
            ItemData(
                R.drawable.id_card,
                "ID Card",
                "Cetak kartu identitas profesional untuk perusahaan, event, sekolah, atau komunitas. " +
                        "Bisa tambah barcode, QR Code, hingga magnet strip.\n\n" +
                        "Bahan plastik PVC berkualitas tinggi, tahan air dan tidak mudah patah. " +
                        "Layanan cetak cepat, bisa kirim desain via email atau WA.\n\n" +
                        "Kami juga menyediakan jasa cetak + tali lanyard sekaligus. Lengkap dan praktis!",
                100000
            )
        )

        produkRecyclerView.layoutManager = LinearLayoutManager(this)
        produkRecyclerView.setHasFixedSize(true)
        produkAdapter = MyAdapter(listProduk)
        produkRecyclerView.adapter = produkAdapter

        produkAdapter.onItemClick = {
            val intent = Intent(this, DetailProduk::class.java)
            intent.putExtra("produk", it)
            startActivity(intent)
        }

    }
}