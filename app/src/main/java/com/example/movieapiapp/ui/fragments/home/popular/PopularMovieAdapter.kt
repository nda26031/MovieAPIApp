package com.example.movieapiapp.ui.fragments.home.popular

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapiapp.R

class PopularMovieAdapter() :
    ListAdapter<PopularMovie, PopularMovieAdapter.PopularMovieViewHolder>(PopularMovieDiffUtil()) {
    class PopularMovieViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val imgMovie: ImageView = item.findViewById(R.id.imgMovie)
        val tvName: TextView = item.findViewById(R.id.tvNameMovie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return PopularMovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: PopularMovieViewHolder, position: Int) {
        val currentItem = currentList[position]
        holder.apply {
            tvName.text = currentItem.title
            Glide.with(itemView.context)
                .load("https://image.tmdb.org/t/p/w500${currentItem.posterPath}")
                .centerCrop()
                .into(imgMovie)
        }
    }

    override fun getItemCount(): Int = currentList.size
}

