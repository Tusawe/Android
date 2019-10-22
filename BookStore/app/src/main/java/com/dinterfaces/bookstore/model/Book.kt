package com.dinterfaces.bookstore.model

data class Book (

    val isbn : String,
    val title : String,
    val description : String

) {

    override fun toString(): String = title

}