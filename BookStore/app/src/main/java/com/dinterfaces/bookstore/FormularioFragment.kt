package com.dinterfaces.bookstore


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*


class FormularioFragment : Fragment() {

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
    lateinit var listaLibros : Button
    lateinit var txtNPaginas : TextView
    lateinit var nLibros : TextView
    var txtFormato : String = "Físico"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_formulario, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val editorialAdapter = ArrayAdapter(context!!, android.R.layout.select_dialog_item, listaEditoriales)
        editorial = view.findViewById(R.id.editorial)
        editorial.threshold = 2
        editorial.setAdapter(editorialAdapter)

        nPaginas = view.findViewById(R.id.nPaginas)
        txtNPaginas = view.findViewById(R.id.textView2)
        txtNPaginas.text = "0"
        nPaginas.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                txtNPaginas.text = "$i"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })
        nLibros = view.findViewById(R.id.nLibros)
        nLibros.text = "0"
        precio = view.findViewById(R.id.precio)
        titulo = view.findViewById(R.id.titulo)
        portada = view.findViewById(R.id.portada)
        isbn = view.findViewById(R.id.isbn)
        autores = view.findViewById(R.id.autores)
        encuadernacion = view.findViewById(R.id.encuadernacion)
        fPublicacion = view.findViewById(R.id.fechaPublicacion)
        sinopsis = view.findViewById(R.id.sinopsis)
        formato = view.findViewById(R.id.radioButton)
        if (formato.isChecked) {
            txtFormato = "Digital"
        }

        insertar = view.findViewById(R.id.insertar)
        insertar.setOnClickListener {

            insertarLibro()

        }

        limpiar = view.findViewById(R.id.limpiar)
        limpiar.setOnClickListener {

            limpiarFormulario()

        }

        listaLibros = view.findViewById(R.id.listaLibros)
        listaLibros.setOnClickListener {

            val intent = Intent (context, ListaLibros::class.java)
            startActivity(intent)

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
        // portada.text.toString()
        if(validar()){
            val libro = Libro(
                titulo.text.toString(),
                "http://abccanino.es/wp-content/uploads/2017/06/19.jpg",
                isbn.text.toString(),
                autores.text.toString(),
                encuadernacion.getItemAtPosition(encuadernacion.selectedItemPosition).toString(),
                fPublicacion.text.toString(),
                sinopsis.text.toString(),
                txtNPaginas.text.toString(),
                precio.text.toString(),
                txtFormato, editorial.text.toString()
            )

            LibrosSingleton.catalogo.add(libro)

            nLibros.text = LibrosSingleton.catalogo.size.toString()

            // limpiarFormulario()
        }

    }

    private fun validar() : Boolean {
        if(titulo.text.toString() == "") {
            Toast.makeText(context, "TÍTULO vacío. Rellenar campo TÍTULO", Toast.LENGTH_SHORT).show()
            return false
        } else if (isbn.text.toString().length != 13) {
            Toast.makeText(context, "Tamaño del ISBN incorrecto, debe tener una longitud de 13 digitos.", Toast.LENGTH_SHORT).show()
            return false
        } else if (precio.text.toString() == "") {
            Toast.makeText(context, "El campo PRECIO no puede estar vacío.", Toast.LENGTH_SHORT).show()
            return false
        } else if (precio.text.toString() == "0") {
            Toast.makeText(context, "El campo PRECIO no puede ser '0'.", Toast.LENGTH_SHORT).show()
            return false
        } else {
            return true
        }

    }


}
