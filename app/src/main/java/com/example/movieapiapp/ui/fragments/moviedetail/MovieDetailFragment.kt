package com.example.movieapiapp.ui.fragments.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.movieapiapp.databinding.FragmentMovieDetailBinding
import com.example.movieapiapp.ui.fragments.home.upcoming.UpcomingMovieViewModel


class MovieDetailFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailBinding
    private val movieDetailViewModel: MovieDetailViewModel by viewModels()
    private val upcomingMovieViewModel: UpcomingMovieViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this afragment
        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movieId = arguments?.getLong("movieId")

        if (movieId != null) {
            movieDetailViewModel.getMovieDetail(movieId)
        }

        movieDetailViewModel.movieDetail.observe(viewLifecycleOwner) { movieDetail ->
            binding.apply {
                tvTitle.text = movieDetail?.originalTitle
                Glide.with(binding.imgMovie.context)
                    .load("https://image.tmdb.org/t/p/w500${movieDetail?.posterPath}")
                    .into(binding.imgMovie)
                tvSubTitle.text = movieDetail?.title
                tvReleaseDate.text = movieDetail?.releaseDate
                tvLanguage.text = movieDetail?.originalLanguage
                tvPopularity.text = movieDetail?.popularity.toString()
                tvOverview.text = movieDetail?.overview
            }
        }

        movieDetailViewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            showLoadingProgressBar(isLoading)
        }
    }

    private fun showLoadingProgressBar(isLoading: Boolean) {
        binding.pbLoading.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}