package com.example.tugas2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val produkList: ArrayList<ItemData>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    var onItemClick : ((ItemData) -> Unit)? = null

    class MyViewHolder (itemData: View) : RecyclerView.ViewHolder (itemData) {
        val gambar: ImageView = itemData.findViewById(R.id.imageView)
        val nama: TextView = itemData.findViewById(R.id.NamaProduk)
        val desk: TextView = itemData.findViewById(R.id.deskProduk)
        val harga: TextView = itemData.findViewById(R.id.hargaProduk)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemData = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return MyViewHolder(itemData)
    }

    override fun getItemCount(): Int = produkList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = produkList[position]
        holder.gambar.setImageResource(item.gambar)
        holder.nama.text = item.nama
        holder.desk.text = item.desk
        holder.harga.text = "Rp %,d".format(item.harga)

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(item)
        }
    }


}