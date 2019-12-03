package com.dinterfaces.listadodelibros

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BookAPI {

// http://192.168.17.196:3000/books/

    @GET("books")
    fun getAllBooks() : Call<List<Book>>

    @GET("books/{id}")
    fun getBook(@Path("id") id : Int) : Call<Book>

}