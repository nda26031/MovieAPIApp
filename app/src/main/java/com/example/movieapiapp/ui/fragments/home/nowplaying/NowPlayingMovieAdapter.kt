package com.example.movieapiapp.ui.fragments.home.nowplaying

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.movieapiapp.R
import com.example.movieapiapp.databinding.ItemMovieBinding

class NowPlayingMovieAdapter :
    ListAdapter<NowPlayingMovie, NowPlayingMovieAdapter.NowPlayingMovieViewHolder>(
        NowPlayingMovieDiffUtil()
    ) {
    class NowPlayingMovieViewHolder(val binding: ItemMovieBinding) : ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingMovieViewHolder {
        val view = ItemMovieBinding.inflate(LayoutInflater.from(parent.context))
        return NowPlayingMovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: NowPlayingMovieViewHolder, position: Int) {
        val currentItem = currentList[position]
        holder.apply {
            binding.tvNameMovie.text = currentItem.title
            Glide.with(holder.itemView)
                .load("https://image.tmdb.org/t/p/w500/eHu1ZxFPmqyhnait9VdsOQBEFOk.jpg")
                .centerCrop()
                .into(holder.binding.imgMovie)
        }
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