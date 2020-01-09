package com.iesvirgendelcarmen.dam.toppeliculas1.Model


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.google.gson.Gson
import com.iesvirgendelcarmen.dam.toppeliculas1.api.APIConfig
import com.iesvirgendelcarmen.dam.toppeliculas1.api.VolleySingleton

class MovieRepository {

    fun  getPopularMovies() : LiveData<Resource<List<Movie>>> {

        val liveData = MutableLiveData<Resource<List<Movie>>>()
        liveData.value = Resource.loading()

        VolleySingleton.getInstance().requestQueue

        val stringRequest = StringRequest(
            Request.Method.GET,
            APIConfig.POPULAR_URL,
            Response.Listener { response ->
                Log.d("LOG", response)
                val resp = Gson().fromJson<MovieResponse>(
                    response,
                    MovieResponse::class.java
                )
                if (resp.movies != null) {
                    liveData.value = Resource.success(resp.movies.orEmpty())
                } else {
                    liveData.value = Resource.error("No more Movies")
                }

            },
            Response.ErrorListener { error ->
                liveData.value = Resource.error(error.message)
            }
        )
        VolleySingleton.getInstance().addToRequestQueue(stringRequest)
        return liveData
    }
}