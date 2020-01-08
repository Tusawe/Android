package com.iesvirgendelcarmen.dam.toppeliculas1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iesvirgendelcarmen.dam.toppeliculas1.Model.Movie
import com.iesvirgendelcarmen.dam.toppeliculas1.R
import com.iesvirgendelcarmen.dam.toppeliculas1.api.APIConfig


class MovieAdapter(var movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun getItemCount() = movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }


    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView = itemView.findViewById<TextView>(R.id.movie_item_title)
        val overviewTextView = itemView.findViewById<TextView>(R.id.movie_item_overview)
        val posterImageView = itemView.findViewById<ImageView>(R.id.movie_item_poster)

        fun bind(movie: Movie) {
            titleTextView.text = movie.title
            var truncatedOverview: String?
            if (movie.overview?.length ?: 0 > 150) {
                truncatedOverview = movie.overview?.substring(0..150)?.substringBeforeLast(' ') + " ..."
            } else
                truncatedOverview = movie.overview

            overviewTextView.text = truncatedOverview ?: ""

            Glide
                .with(itemView)
                .load("${APIConfig.IMAGE_BASE_URL}${movie.posterPath}")
                .centerCrop()
                .into(posterImageView)
        }
    }

}

