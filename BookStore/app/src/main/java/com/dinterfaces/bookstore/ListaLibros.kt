package com.dinterfaces.bookstore

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaLibros : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_libros)

        val provider: ViewModelProvider = ViewModelProviders.of(this)
        val libroViewModel = provider.get(LibroViewModel::class.java)

        val hotelRecyclerView = findViewById<RecyclerView>(R.id.listaLibros).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            //layoutManager = GridLayoutManager(this@MainActivity,4, GridLayoutManager.HORIZONTAL,false)
            adapter = LibroAdapter(libroViewModel.libros, object : LibroAdapter.OnItemClickListener {
                override fun onClicked(libro: Libro) {
                    Toast.makeText(this, libro.titulo, Toast.LENGTH_SHORT).show()
                }

            })
        }


    }


}