package com.iesvirgendelcarmen.dam.toppeliculas1.Model

import com.google.gson.annotations.SerializedName


data class MovieResponse(
    @SerializedName("page")
    var page: Int = 0,
    @SerializedName("total_results")
    var totalResults: Int = 0,
    @SerializedName("results")
    var movies: List<Movie>? = null,
    @SerializedName("total_pages")
    var totalPages: Int = 0
)
