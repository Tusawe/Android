package com.iesvirgendelcarmen.dam.toppeliculas1.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MovieViewModel : ViewModel() {

    var resourceMovies : LiveData<Resource<List<Movie>>> = MutableLiveData()

    fun getPopularMovies() {
        resourceMovies = MovieRepository().getPopularMovies()
    }
}