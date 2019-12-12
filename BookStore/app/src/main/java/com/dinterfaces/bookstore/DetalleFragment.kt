package com.dinterfaces.bookstore


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

/**
 * A simple [Fragment] subclass.
 */
class DetalleFragment : Fragment() {

    lateinit var titulo : TextView
    lateinit var portada : ImageView
    lateinit var precio : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        titulo = view.findViewById(R.id.detalle_titulo)
        portada = view.findViewById(R.id.detalle_imagen)
        precio = view.findViewById(R.id.detalle_precio)

        val libro = arguments?.get("book") as Libro

        titulo.text = libro.titulo
        precio.text = "Precio: " + libro.precio + "€"
        Glide
            .with(this)
            .load(libro.portada)
            .centerInside()
            .into(portada)

    }

}
