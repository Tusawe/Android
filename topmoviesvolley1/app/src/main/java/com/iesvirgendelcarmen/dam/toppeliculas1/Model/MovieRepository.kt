package com.iesvirgendelcarmen.dam.toppeliculas1.Model

import android.content.Context
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.iesvirgendelcarmen.dam.toppeliculas1.api.APIConfig

class MovieRepository {

    fun getPopularMovies(context: Context, callback : MovieCallback) {
        val queue = Volley.newRequestQueue(context)
        val stringRequest = StringRequest(
            Request.Method.GET,
            APIConfig.POPULAR_URL,
            Response.Listener {
                val resp = Gson().fromJson<MovieResponse>(
                    it,
                    MovieResponse::class.java
                )
                if(resp.movies != null) callback.onMovieResponse(resp.movies!!)
                else callback.onMovieEmpty()

            },
            Response.ErrorListener {
                callback.onMovieError()
            }
        )
        queue.add(stringRequest)
    }

}

interface MovieCallback {
    fun onMovieResponse(movie: List<Movie>)
    fun onMovieError()
    fun onMovieEmpty()
}
