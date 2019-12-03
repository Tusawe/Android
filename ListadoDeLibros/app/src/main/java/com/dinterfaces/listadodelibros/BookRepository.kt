package com.dinterfaces.listadodelibros

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BookRepository {

    val api : BookAPI

    init {

        val retrofit = Retrofit.Builder().baseUrl("http://192.168.17.196:3000/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        api = retrofit.create(BookAPI::class.java)

    }

    fun getAllBooks(callback: BookListCallback) {
        callback.onBookLoading()
        val call = api.getAllBooks()
        call.enqueue(object: Callback<List<Book>>{
            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                callback.onBookError(t.message.toString())
            }

            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                val booklist = response.body().orEmpty()
                callback.onBookResponse(booklist)
            }

        })
    }

    interface BookListCallback {

        fun onBookLoading()
        fun onBookError(msg : String)
        fun onBookResponse(bookList : List<Book>)

    }

}