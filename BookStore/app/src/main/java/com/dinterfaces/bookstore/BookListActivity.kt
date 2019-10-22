package com.dinterfaces.bookstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.dinterfaces.bookstore.model.Book
import com.dinterfaces.bookstore.model.Repository

class BookListActivity : AppCompatActivity(), OnBookSelected {

    var dual = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentBookDetail = findViewById<View>(R.id.fragmentBookDetail)

        dual = fragmentBookDetail?.visibility == View.VISIBLE

    }

    override fun displayBookDetail(book: Book) {
        if (dual) {



        } else {



        }
    }

}
