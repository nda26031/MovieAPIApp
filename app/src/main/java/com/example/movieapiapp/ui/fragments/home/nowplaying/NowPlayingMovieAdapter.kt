package com.example.movieapiapp.ui.fragments.home.nowplaying

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.movieapiapp.databinding.ItemMovieBinding

class NowPlayingMovieAdapter(private val onClickMovie: (Long) -> Unit) :
    ListAdapter<NowPlayingMovie, NowPlayingMovieAdapter.NowPlayingMovieViewHolder>(
        NowPlayingMovieDiffUtil()
    ) {
    class NowPlayingMovieViewHolder(
        val binding: ItemMovieBinding,
        private val onClickMovie: (Long) -> Unit
    ) : ViewHolder(binding.root) {
        fun bind(currentItem: NowPlayingMovie){
            binding.tvNameMovie.text = currentItem.title
            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w500/${currentItem.posterPath}")
                .centerCrop()
                .into(binding.imgMovie)

            binding.root.setOnClickListener {
                onClickMovie.invoke(currentItem.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingMovieViewHolder {
        val view = ItemMovieBinding.inflate(LayoutInflater.from(parent.context))
        return NowPlayingMovieViewHolder(view,onClickMovie)
    }

    override fun onBindViewHolder(holder: NowPlayingMovieViewHolder, position: Int) {
        val currentItem = currentList[position]
        holder.bind(currentItem)
    }
}

class NowPlayingMovieDiffUtil : DiffUtil.ItemCallback<NowPlayingMovie>() {
    override fun areItemsTheSame(oldItem: NowPlayingMovie, newItem: NowPlayingMovie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: NowPlayingMovie, newItem: NowPlayingMovie): Boolean {
        return oldItem == newItem
    }

}