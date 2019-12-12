package com.dinterfaces.bookstore

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Libro (var titulo : String, var portada : String,
                  var isbn : String, var autores : String,
                  var encuadernacion : String, var fPublicacion : String,
                  var sinopsis : String, var nPaginas : String,
                  var precio : String, var formato : String,
                  var editorial : String) : Parcelable
