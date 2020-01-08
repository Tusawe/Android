package com.iesvirgendelcarmen.dam.toppeliculas1.Model

import com.google.gson.annotations.SerializedName


data class Movie(
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("poster_path")
    var posterPath: String? = null,
    @SerializedName("overview")
    var overview: String? = null,
    @SerializedName("release_date")
    var releaseDate: String? = null,
    @SerializedName("vote_average")
    var rating: Float = 0f,
    @SerializedName("genre_ids")
    var genreIds: List<Int>? = null
)