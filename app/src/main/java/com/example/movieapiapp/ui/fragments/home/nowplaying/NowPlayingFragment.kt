package com.example.movieapiapp.ui.fragments.home.nowplaying

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapiapp.R
import com.example.movieapiapp.databinding.FragmentNowPlayingBinding

class NowPlayingFragment : Fragment() {

    private lateinit var binding: FragmentNowPlayingBinding
    private val nowPlayingMovieViewModel: NowPlayingMovieViewModel by viewModels()
    private val nowPlayingMovieAdapter: NowPlayingMovieAdapter by lazy {
        NowPlayingMovieAdapter(onClickMovie = { movieId ->
            onClickMovie(movieId)
        })
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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

        nowPlayingMovieViewModel.nowPlayingMovie
            .observe(viewLifecycleOwner) { upcomingMovieList ->
                nowPlayingMovieAdapter.submitList(upcomingMovieList)
                binding.rcvNowPlaying.adapter = nowPlayingMovieAdapter
            }

    }

    private fun prepareRecyclerView() {
        binding.rcvNowPlaying.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = nowPlayingMovieAdapter
        }
    }

    private fun showLoadingProgressBar(isLoading: Boolean) {
        binding.pbLoading.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun onClickMovie(movieId: Long) {
        val bundle = Bundle()
        bundle.putLong("movieId", movieId)
        findNavController().navigate(R.id.action_mainFragment_to_movieDetailFragment, bundle)
    }

}