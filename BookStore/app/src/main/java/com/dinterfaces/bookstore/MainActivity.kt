package com.dinterfaces.bookstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private var listaEditoriales =
        arrayOf("Anaya", "Mac Graw Hill", "Oreilly", "Apress", "Manning", "Pretince Hall", "Rama")
    lateinit var editorial : AutoCompleteTextView
    lateinit var insertar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.formulario)

        val editorialAdapter = ArrayAdapter(this, android.R.layout.select_dialog_item, listaEditoriales)
        editorial = findViewById(R.id.editorial)
        editorial.threshold = 2
        editorial.setAdapter(editorialAdapter)

        insertar = findViewById(R.id.insertar)
        insertar.setOnClickListener {

            insertarLibro()

        }

    }

    private fun insertarLibro() {

        val libro = Libro(

        )

    }


}
