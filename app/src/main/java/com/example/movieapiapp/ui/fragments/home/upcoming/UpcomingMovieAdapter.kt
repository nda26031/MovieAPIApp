package com.example.movieapiapp.ui.fragments.home.upcoming

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapiapp.databinding.ItemMovieBinding

class UpcomingMovieAdapter :
    ListAdapter<UpcomingMovie, UpcomingMovieAdapter.UpcomingMovieViewHolder>(UpcomingMovieDiffUtil()) {
    class UpcomingMovieViewHolder(val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingMovieViewHolder {
        val view = ItemMovieBinding.inflate(LayoutInflater.from(parent.context))
        return UpcomingMovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: UpcomingMovieViewHolder, position: Int) {
        val currentItem = currentList[position]
        holder.apply {
            binding.tvNameMovie.text = currentItem.title
            Glide.with(holder.itemView)
                .load("https://image.tmdb.org/t/p/w500${currentItem.posterPath}")
                .into(holder.binding.imgMovie)
        }
    }

    override fun getItemCount(): Int = currentList.size

}


class UpcomingMovieDiffUtil : DiffUtil.ItemCallback<UpcomingMovie>() {
    override fun areItemsTheSame(oldItem: UpcomingMovie, newItem: UpcomingMovie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UpcomingMovie, newItem: UpcomingMovie): Boolean {
        return oldItem == newItem
    }

}