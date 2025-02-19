package com.example.movieapiapp.ui.fragments.home.toprates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.movieapiapp.databinding.FragmentTopRatesBinding
import com.example.movieapiapp.databinding.ItemMovieBinding

class TopRatedMovieAdapter : RecyclerView.Adapter<TopRatedMovieAdapter.TopRatedMovieViewHolder>() {
    private var movieList = ArrayList<TopRatedMovie>()

    class TopRatedMovieViewHolder(val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {}

    fun setMovieList(movieList: List<TopRatedMovie>) {
        this.movieList = movieList as ArrayList<TopRatedMovie>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedMovieViewHolder {
        val view = ItemMovieBinding.inflate(LayoutInflater.from(parent.context))
        return TopRatedMovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: TopRatedMovieViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500" + movieList[position].posterPath)
            .into(holder.binding.imgMovie)
        holder.binding.tvNameMovie.text = movieList[position].title
    }
}