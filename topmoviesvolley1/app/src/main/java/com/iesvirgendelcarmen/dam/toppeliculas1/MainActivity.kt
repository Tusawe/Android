package com.iesvirgendelcarmen.dam.toppeliculas1

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.iesvirgendelcarmen.dam.toppeliculas1.Model.*
import com.iesvirgendelcarmen.dam.toppeliculas1.adapter.MovieAdapter
import com.iesvirgendelcarmen.dam.toppeliculas1.api.APIConfig
import com.iesvirgendelcarmen.dam.toppeliculas1.api.VolleySingleton

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var movieAdapter = MovieAdapter(emptyList())
    private val movieViewModel : MovieViewModel by lazy {
        ViewModelProviders.of(this).get(MovieViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.movies)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = movieAdapter
        }

        movieViewModel.getPopularMovies()
        movieViewModel.resourceMovies.observe(this, Observer {
            movieResource ->
            when (movieResource.status) {
                Resource.Status.SUCCESS -> {
                    movieAdapter.movies = movieResource.data!!
                    movieAdapter.notifyDataSetChanged()
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(this, "Network error", Toast.LENGTH_LONG).show()
                }
                Resource.Status.LOADING -> {
                    Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}
