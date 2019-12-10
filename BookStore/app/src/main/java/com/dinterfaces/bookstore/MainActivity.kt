package com.dinterfaces.bookstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    private var listaEditoriales =
        arrayOf("Anaya", "Mac Graw Hill", "Oreilly", "Apress", "Manning", "Pretince Hall", "Rama")
    lateinit var titulo : EditText
    lateinit var portada : EditText
    lateinit var isbn : EditText
    lateinit var autores : EditText
    lateinit var encuadernacion : EditText
    lateinit var fPublicacion : EditText
    lateinit var sinopsis : EditText
    lateinit var nPaginas : SeekBar
    lateinit var precio : EditText
    lateinit var formato : RadioButton
    lateinit var editorial : AutoCompleteTextView
    lateinit var insertar : Button
    lateinit var limpiar : Button
    lateinit var txtNPaginas : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.formulario)

        val editorialAdapter = ArrayAdapter(this, android.R.layout.select_dialog_item, listaEditoriales)
        editorial = findViewById(R.id.editorial)
        editorial.threshold = 2
        editorial.setAdapter(editorialAdapter)

        nPaginas = findViewById(R.id.nPaginas)
        txtNPaginas = findViewById(R.id.textView2)
        txtNPaginas.text = "0"
        nPaginas.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                txtNPaginas.text = "$i"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        precio = findViewById(R.id.precio)
        precio.setOnChecked

        titulo = findViewById(R.id.titulo)
        portada = findViewById(R.id.portada)
        isbn = findViewById(R.id.isbn)
        autores = findViewById(R.id.autores)
        encuadernacion = findViewById(R.id.encuadernacion)
        fPublicacion = findViewById(R.id.fechaPublicacion)
        sinopsis = findViewById(R.id.sinopsis)
        formato = findViewById(R.id.radioButton)

        insertar = findViewById(R.id.insertar)
        insertar.setOnClickListener {

            insertarLibro()

        }

        limpiar = findViewById(R.id.limpiar)
        limpiar.setOnClickListener {

            limpiarFormulario()

        }

    }

    private fun limpiarFormulario() {

    }

    private fun insertarLibro() {

        val libro = Libro(
            titulo.text.toString(),
            portada.text.toString(),
            isbn.text.toString(),
            autores.text.toString(),
            encuadernacion.text.toString(),
            fPublicacion.text.toString(),
            sinopsis.text.toString(),
            txtNPaginas.text.toString(),
            precio.text.toString(),
            formato.

        )

        limpiarFormulario()

    }


}
