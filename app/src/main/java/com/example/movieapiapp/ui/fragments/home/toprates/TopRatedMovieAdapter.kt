package com.example.movieapiapp.ui.fragments.home.toprates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.movieapiapp.databinding.FragmentTopRatesBinding
import com.example.movieapiapp.databinding.ItemMovieBinding
import com.example.movieapiapp.ui.fragments.home.upcoming.UpcomingMovie

class TopRatedMovieAdapter : ListAdapter<TopRatedMovie,TopRatedMovieAdapter.TopRatedMovieViewHolder>(TopRatedMovieDiffUtil()) {
    class TopRatedMovieViewHolder(val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedMovieViewHolder {
        val view = ItemMovieBinding.inflate(LayoutInflater.from(parent.context))
        return TopRatedMovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun onBindViewHolder(holder: TopRatedMovieViewHolder, position: Int) {
        val currentItem = currentList[position]
        holder.apply {
            binding.tvNameMovie.text = currentItem.title
            Glide.with(holder.itemView)
                .load("https://image.tmdb.org/t/p/w500${currentItem.posterPath}")
                .into(holder.binding.imgMovie)
        }
    }
}

class TopRatedMovieDiffUtil : DiffUtil.ItemCallback<TopRatedMovie>() {
    override fun areItemsTheSame(oldItem: TopRatedMovie, newItem: TopRatedMovie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TopRatedMovie, newItem: TopRatedMovie): Boolean {
        return oldItem == newItem
    }

}