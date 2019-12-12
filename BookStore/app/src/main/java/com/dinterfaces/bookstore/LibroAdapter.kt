package com.dinterfaces.bookstore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class LibroAdapter(private val libros: List<Libro>, val itemClickListener: OnItemClickListener) : RecyclerView.Adapter<LibroAdapter.LibroViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.libro_item, parent, false)
        return LibroViewHolder(view)
    }

    override fun getItemCount() = libros.size

    override fun onBindViewHolder(holder: LibroViewHolder, position: Int) {
        val libro = libros[position]
        holder.bind(libro, itemClickListener)
    }

    inner class LibroViewHolder(view: View) :RecyclerView.ViewHolder(view) {

        val nameTextView = itemView.findViewById<TextView>(R.id.book_name)
        val priceTextView = itemView.findViewById<TextView>(R.id.book_price)
        val photoImageView = itemView.findViewById<ImageView>(R.id.book_photo)

        fun bind(libro: Libro, clickListener: OnItemClickListener) {
            nameTextView.text = libro.titulo
            priceTextView.text = "Precio: " + libro.precio + "€"
            Glide
                .with(itemView.context)
                .load(libro.portada)
                .centerInside()
                .into(photoImageView)

            itemView.setOnClickListener{
                clickListener.onClicked(libro)
            }
        }
    }

    interface OnItemClickListener {
        fun onClicked(libro: Libro)
    }

}