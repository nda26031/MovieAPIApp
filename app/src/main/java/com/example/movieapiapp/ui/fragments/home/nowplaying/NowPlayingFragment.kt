package com.example.movieapiapp.ui.fragments.home.nowplaying

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapiapp.R
import com.example.movieapiapp.databinding.FragmentNowPlayingBinding
import com.example.movieapiapp.databinding.FragmentUpComingBinding
import com.example.movieapiapp.ui.fragments.home.upcoming.UpcomingMovieAdapter

class NowPlayingFragment : Fragment() {

    private lateinit var binding: FragmentNowPlayingBinding
    private val nowPlayingMovieViewModel: NowPlayingMovieViewModel by viewModels()
    private var nowPlayingMovieAdapter = NowPlayingMovieAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNowPlayingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prepareRecyclerView()

        nowPlayingMovieViewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            showLoadingProgressBar(isLoading)
        }

        nowPlayingMovieViewModel.getNowPlayingMovieList()
        nowPlayingMovieViewModel.nowPlayingMovie
            .observe(viewLifecycleOwner) { upcomingMovieList ->
                nowPlayingMovieAdapter.submitList(upcomingMovieList)
                binding.rcvNowPlaying.adapter = nowPlayingMovieAdapter
            }

    }

    private fun prepareRecyclerView() {
        nowPlayingMovieAdapter = NowPlayingMovieAdapter()
        binding.rcvNowPlaying.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = nowPlayingMovieAdapter
        }
    }

    private fun showLoadingProgressBar(isLoading: Boolean) {
        binding.pbLoading.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

}