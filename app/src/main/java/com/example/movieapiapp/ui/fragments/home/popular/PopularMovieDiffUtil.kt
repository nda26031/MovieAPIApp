package com.example.movieapiapp.ui.fragments.home.popular

import androidx.recyclerview.widget.DiffUtil

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