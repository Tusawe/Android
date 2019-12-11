package com.dinterfaces.bookstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.dinterfaces.bookstore.LibrosSingleton.catalogo

class MainActivity : AppCompatActivity() {

    private var listaEditoriales = arrayOf("Anaya", "Mac Graw Hill", "Oreilly", "Apress", "Manning", "Pretince Hall", "Rama")
    lateinit var titulo : EditText
    lateinit var portada : EditText
    lateinit var isbn : EditText
    lateinit var autores : EditText
    lateinit var encuadernacion : Spinner
    lateinit var fPublicacion : EditText
    lateinit var sinopsis : EditText
    lateinit var nPaginas : SeekBar
    lateinit var precio : EditText
    lateinit var formato : RadioButton
    lateinit var editorial : AutoCompleteTextView
    lateinit var insertar : Button
    lateinit var limpiar : Button
    lateinit var txtNPaginas : TextView
    lateinit var nLibros : TextView
    var txtFormato : String = "Físico"

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
        nLibros = findViewById(R.id.nLibros)
        nLibros.text = "0"
        precio = findViewById(R.id.precio)
        titulo = findViewById(R.id.titulo)
        portada = findViewById(R.id.portada)
        isbn = findViewById(R.id.isbn)
        autores = findViewById(R.id.autores)
        encuadernacion = findViewById(R.id.encuadernacion)
        fPublicacion = findViewById(R.id.fechaPublicacion)
        sinopsis = findViewById(R.id.sinopsis)
        formato = findViewById(R.id.radioButton)
        if (formato.isChecked) {
            txtFormato = "Digital"
        }

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

        titulo.setText("")
        portada.setText("")
        isbn.setText("")
        autores.setText("")
        encuadernacion.setSelection(0)
        fPublicacion.setText("")
        sinopsis.setText("")
        txtNPaginas.text = "0"
        precio.setText("0")
        formato.isChecked = false
        editorial.setText("")

    }

    private fun insertarLibro() {

        if(validar()){
            val libro = Libro(
                titulo.text.toString(),
                portada.text.toString(),
                isbn.text.toString(),
                autores.text.toString(),
                encuadernacion.getItemAtPosition(encuadernacion.selectedItemPosition).toString(),
                fPublicacion.text.toString(),
                sinopsis.text.toString(),
                txtNPaginas.text.toString(),
                precio.text.toString(),
                txtFormato, editorial.text.toString()
            )

            catalogo.add(libro)

            nLibros.text = catalogo.size.toString()

            limpiarFormulario()
        }

    }

    private fun validar() : Boolean {
        if(titulo.text.toString() == "") {
            Toast.makeText(this, "TÍTULO vacío. Rellenar campo TÍTULO", Toast.LENGTH_SHORT).show()
            return false
        } else if (isbn.text.toString().length != 13) {
            Toast.makeText(this, "Tamaño del ISBN incorrecto, debe tener una longitud de 13 digitos.", Toast.LENGTH_SHORT).show()
            return false
        } else if (precio.text.toString() == "") {
            Toast.makeText(this, "El campo PRECIO no puede estar vacío.", Toast.LENGTH_SHORT).show()
            return false
        } else if (precio.text.toString() == "0") {
            Toast.makeText(this, "El campo PRECIO no puede ser '0'.", Toast.LENGTH_SHORT).show()
            return false
        } else {
            return true
        }

    }

}
