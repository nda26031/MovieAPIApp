package com.example.movieapiapp.ui.fragments.home.upcoming

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapiapp.databinding.ItemMovieBinding

class UpcomingMovieAdapter(private val onClickMovie: (Long) -> Unit) :
    ListAdapter<UpcomingMovie, UpcomingMovieAdapter.UpcomingMovieViewHolder>(UpcomingMovieDiffUtil()) {
    class UpcomingMovieViewHolder(
        private val binding: ItemMovieBinding,
        private val onClickMovie: (Long) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(currentItem: UpcomingMovie) {
            binding.tvNameMovie.text = currentItem.title
            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w500${currentItem.posterPath}")
                .into(binding.imgMovie)

            binding.root.setOnClickListener {
                onClickMovie.invoke(currentItem.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingMovieViewHolder {
        val view = ItemMovieBinding.inflate(LayoutInflater.from(parent.context))
        return UpcomingMovieViewHolder(view, onClickMovie)
    }

    override fun onBindViewHolder(holder: UpcomingMovieViewHolder, position: Int) {
        val currentItem = currentList[position]
        holder.bind(currentItem)
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