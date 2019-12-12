package com.dinterfaces.bookstore

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaLibros : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_libros)

        val libroRecyclerView = findViewById<RecyclerView>(R.id.listaLibros).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = LibroAdapter(LibrosSingleton.catalogo, object : LibroAdapter.OnItemClickListener {
                override fun onClicked(libro: Libro) {
                    Toast.makeText(context, libro.titulo, Toast.LENGTH_SHORT).show()
//                    val intent = Intent(context, LibroDetalle::class.java)
//                    intent.putExtra("book", libro)
//                    startActivity(intent)
                    val detailFragment = DetalleFragment()
                    val bundle = Bundle()
                    bundle.putParcelable("book", libro)
                    detailFragment.arguments = bundle

                    supportFragmentManager.beginTransaction().replace(R.id.container, detailFragment).addToBackStack(null).commit()

                }

            })
        }


    }


}