package com.example.latihanrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListHeroAdapter (private val listhero: ArrayList<Hero>) :
    RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero,parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listhero.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listhero[position]
        holder.imgitemphoto.setImageResource(photo)
        holder.tvnameitem.text = name
        holder.tvitemdescription.text = description
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Kamu memilih " + listhero[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgitemphoto : ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvnameitem : TextView = itemView.findViewById(R.id.tv_name_item)
        val tvitemdescription : TextView = itemView.findViewById(R.id.tv_item_description)
    }
}