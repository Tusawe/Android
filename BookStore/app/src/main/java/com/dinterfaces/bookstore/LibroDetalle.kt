package com.dinterfaces.bookstore

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class LibroDetalle : AppCompatActivity() {

    lateinit var titulo : TextView
    lateinit var portada : ImageView
    lateinit var precio : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalle_libro)

        titulo = findViewById(R.id.detalle_titulo)
        portada = findViewById(R.id.detalle_imagen)
        precio = findViewById(R.id.detalle_precio)

        val libro = intent.getParcelableExtra("book") as Libro

        titulo.text = libro.titulo
        precio.text = "Precio: " + libro.precio + "€"
        Glide
            .with(this)
            .load(libro.portada)
            .centerInside()
            .into(portada)

    }

}