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
import com.example.movieapiapp.databinding.ItemMovieBinding

class PopularMovieAdapter() :
    ListAdapter<PopularMovie, PopularMovieAdapter.PopularMovieViewHolder>(PopularMovieDiffUtil()) {
    class PopularMovieViewHolder(val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieViewHolder {
        val view = ItemMovieBinding.inflate(LayoutInflater.from(parent.context))
        return PopularMovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: PopularMovieViewHolder, position: Int) {
        val currentItem = currentList[position]
        holder.apply {
            binding.tvNameMovie.text = currentItem.title
            Glide.with(holder.itemView)
                .load("https://image.tmdb.org/t/p/w500${currentItem.posterPath}")
                .centerCrop()
                .into(holder.binding.imgMovie)
        }
    }

    override fun getItemCount(): Int = currentList.size
}

