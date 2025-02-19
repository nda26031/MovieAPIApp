package com.example.movieapiapp.ui.fragments.home.toprates

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapiapp.R
import com.example.movieapiapp.databinding.FragmentTopRatesBinding
import com.example.movieapiapp.databinding.FragmentUpComingBinding


class TopRatesFragment : Fragment() {
    private lateinit var binding: FragmentTopRatesBinding
    private val topRatedMovieViewModel: TopRatedMovieViewModel by viewModels()
    private lateinit var topRatedMovieAdapter: TopRatedMovieAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTopRatesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareRecyclerView()

        topRatedMovieViewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            showLoadingProgressBar(isLoading)
        }

        topRatedMovieViewModel.getPopularMovies()
        topRatedMovieViewModel.topRatedMovie.observe(viewLifecycleOwner) { movieList ->
            topRatedMovieAdapter.submitList(movieList)
        }

    }

    private fun prepareRecyclerView() {
        topRatedMovieAdapter = TopRatedMovieAdapter()
        binding.rcvNowPlaying.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = topRatedMovieAdapter
        }
    }

    private fun showLoadingProgressBar(isLoading: Boolean) {
        binding.pbLoading.visibility = if (isLoading) View.VISIBLE else View.GONE
    }


}