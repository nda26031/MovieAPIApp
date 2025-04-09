package com.example.movieapiapp.ui.fragments.home.upcoming

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapiapp.R
import com.example.movieapiapp.databinding.FragmentUpComingBinding


class UpComingFragment : Fragment() {

    private lateinit var binding: FragmentUpComingBinding
    private val upcomingMovieViewModel: UpcomingMovieViewModel by viewModels()
    private val upcomingMovieAdapter by lazy {
        UpcomingMovieAdapter(onClickMovie = { movieId ->
            onClickMovie(movieId)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentUpComingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prepareRecyclerView()

        upcomingMovieViewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            showLoadingProgressBar(isLoading)
        }

//        upcomingMovieViewModel.getUpcomingMovieList() // Nên đặt trong fun init{} in ViewModel tránh gọi lại onViewCreated
        upcomingMovieViewModel.upcomingMovie
            .observe(viewLifecycleOwner) { upcomingMovieList ->
                upcomingMovieAdapter.submitList(upcomingMovieList)
                binding.rcvUpcoming.adapter = upcomingMovieAdapter
            }
    }

    private fun prepareRecyclerView() {
        binding.rcvUpcoming.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = upcomingMovieAdapter
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