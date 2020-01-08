package com.iesvirgendelcarmen.dam.toppeliculas1.api

object APIConfig {
    const val API_KEY = "ecade04f0950fc78674036e1ed5c4931"
    const val API_URL_BASE = "https://api.themoviedb.org/3/"
    const val IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w200"
    const val POPULAR_URL = "${API_URL_BASE}movie/popular?language=es&api_key=$API_KEY"
    const val MOVIE_URL = "${API_URL_BASE}movie/%d?language=es&api_key=$API_KEY"
}
