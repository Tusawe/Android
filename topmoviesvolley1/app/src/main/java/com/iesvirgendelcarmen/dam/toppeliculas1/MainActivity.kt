package com.iesvirgendelcarmen.dam.toppeliculas1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.google.gson.Gson
import com.iesvirgendelcarmen.dam.toppeliculas1.Model.Movie
import com.iesvirgendelcarmen.dam.toppeliculas1.Model.MovieCallback
import com.iesvirgendelcarmen.dam.toppeliculas1.Model.MovieRepository
import com.iesvirgendelcarmen.dam.toppeliculas1.Model.MovieResponse
import com.iesvirgendelcarmen.dam.toppeliculas1.adapter.MovieAdapter
import com.iesvirgendelcarmen.dam.toppeliculas1.api.APIConfig
import com.iesvirgendelcarmen.dam.toppeliculas1.api.VolleySingleton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    var movieAdapter = MovieAdapter(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.movies)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = movieAdapter
        }

        val callback = object : MovieCallback {
            override fun onMovieResponse(movies: List<Movie>) {
                movieAdapter.movies = movies
                movieAdapter.notifyDataSetChanged()
            }

            override fun onMovieError() {
                Toast.makeText(this@MainActivity, "ERROR.", Toast.LENGTH_SHORT).show()
            }

            override fun onMovieEmpty() {
                Toast.makeText(this@MainActivity, "ERROR.", Toast.LENGTH_SHORT).show()
            }


        }

        MovieRepository().getPopularMovies(this, callback)

    }


}
