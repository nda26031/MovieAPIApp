package com.example.movieapiapp.ui.fragments.home.toprates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapiapp.databinding.ItemMovieBinding

class TopRatedMovieAdapter(private val onClickMovie: (Long) -> Unit) :
    ListAdapter<TopRatedMovie, TopRatedMovieAdapter.TopRatedMovieViewHolder>(TopRatedMovieDiffUtil()) {
    class TopRatedMovieViewHolder(
        private val binding: ItemMovieBinding,
        private val onClickMovie: (Long) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(currentItem: TopRatedMovie) {
            binding.tvNameMovie.text = currentItem.title
            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w500${currentItem.posterPath}")
                .into(binding.imgMovie)

            binding.root.setOnClickListener {
                onClickMovie.invoke(currentItem.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedMovieViewHolder {
        val view = ItemMovieBinding.inflate(LayoutInflater.from(parent.context))
        return TopRatedMovieViewHolder(view, onClickMovie)
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun onBindViewHolder(holder: TopRatedMovieViewHolder, position: Int) {
        val currentItem = currentList[position]
        holder.bind(currentItem)
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