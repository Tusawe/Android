package com.dinterfaces.bookstore


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 */
class ListaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val libroRecyclerView = view.findViewById<RecyclerView>(R.id.listaLibros).apply {
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

                    fragmentManager!!.beginTransaction().replace(R.id.container, detailFragment).addToBackStack(null).commit()

                }

            })
        }

    }

}
