package com.dinterfaces.bookstore

import java.io.Serializable

data class Libro (var titulo : String, var portada : String,
                  var isbn : String, var autores : String,
                  var encuadernacion : String, var fPublicacion : String,
                  var sinopsis : String, var nPaginas : String,
                  var precio : String, var formato : String,
                  var editorial : String) : Serializable
