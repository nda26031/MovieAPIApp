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

class PopularMovieAdapter(private val onClickMovie: (Long) -> Unit) :
    ListAdapter<PopularMovie, PopularMovieAdapter.PopularMovieViewHolder>(PopularMovieDiffUtil()) {
    class PopularMovieViewHolder(
        val binding: ItemMovieBinding,
        private val onClickMovie: (Long) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(currentItem: PopularMovie) {
            binding.tvNameMovie.text = currentItem.title
            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w500${currentItem.posterPath}")
                .centerCrop()
                .into(binding.imgMovie)

            binding.root.setOnClickListener {
                onClickMovie.invoke(currentItem.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieViewHolder {
        val view = ItemMovieBinding.inflate(LayoutInflater.from(parent.context))
        return PopularMovieViewHolder(view, onClickMovie)
    }

    override fun onBindViewHolder(holder: PopularMovieViewHolder, position: Int) {
        val currentItem = currentList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int = currentList.size
}


class PopularMovieDiffUtil : DiffUtil.ItemCallback<PopularMovie>() {
    override fun areItemsTheSame(oldItem: PopularMovie, newItem: PopularMovie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: PopularMovie,
        newItem: PopularMovie
    ): Boolean {
        return oldItem == newItem
    }
}


