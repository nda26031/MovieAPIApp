package com.example.movieapiapp.ui.fragments.home.toprates

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapiapp.R
import com.example.movieapiapp.databinding.FragmentTopRatesBinding
import com.example.movieapiapp.databinding.FragmentUpComingBinding


class TopRatesFragment : Fragment() {
    private lateinit var binding: FragmentTopRatesBinding
    private lateinit var topRatedMovieViewModel: TopRatedMovieViewModel
    private lateinit var topRatedMovieAdapter : TopRatedMovieAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_rates, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTopRatesBinding.bind(view)

        prepareRecyclerView()

        topRatedMovieViewModel = ViewModelProvider(this)[TopRatedMovieViewModel::class.java]
        topRatedMovieViewModel.getPopularMovies()
        topRatedMovieViewModel.observeMovieLiveData().observe(viewLifecycleOwner, Observer { movieList ->
            topRatedMovieAdapter.setMovieList(movieList)
        })

    }

    private fun prepareRecyclerView() {
        topRatedMovieAdapter = TopRatedMovieAdapter()
        binding.rcvNowPlaying.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = topRatedMovieAdapter
        }
    }
}