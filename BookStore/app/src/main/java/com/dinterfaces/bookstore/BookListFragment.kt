package com.dinterfaces.bookstore

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.dinterfaces.bookstore.model.Book
import com.dinterfaces.bookstore.model.Repository
import java.lang.ClassCastException

class BookListFragment : Fragment() {

    private lateinit var listener : OnBookSelected

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is OnBookSelected) {

            listener = context

        } else {

            throw ClassCastException("El activity debe implementar OnBookSelected")

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val listView = view.findViewById<ListView>(R.id.listViewBooks)
        val adapter = ArrayAdapter<Book>(activity!!, android.R.layout.simple_list_item_1, Repository.books)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->

            listener.displayBookDetail(Repository.books.get(position))

        }

    }

}

interface OnBookSelected {

    fun displayBookDetail(book : Book)

}
