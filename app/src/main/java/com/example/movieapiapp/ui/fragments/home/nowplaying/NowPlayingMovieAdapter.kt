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

class NowPlayingMovieAdapter :
    ListAdapter<NowPlayingMovie, NowPlayingMovieAdapter.NowPlayingMovieViewHolder>(
        NowPlayingMovieDiffUtil()
    ) {
    class NowPlayingMovieViewHolder(private val itemView: View) : ViewHolder(itemView) {
        val imgMovie: ImageView = itemView.findViewById(R.id.imgMovie)
        val tvName: TextView = itemView.findViewById(R.id.tvNameMovie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingMovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return NowPlayingMovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: NowPlayingMovieViewHolder, position: Int) {
        val currentItem = currentList[position]
        holder.apply {
            tvName.text = currentItem.title
            Glide.with(imgMovie.context)
                .load("https://image.tmdb.org/t/p/w500${currentItem.posterPath}")
                .centerCrop()
                .into(imgMovie)
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