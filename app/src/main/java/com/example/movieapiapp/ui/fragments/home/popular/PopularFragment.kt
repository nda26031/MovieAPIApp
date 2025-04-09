package com.example.movieapiapp.ui.fragments.home.popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapiapp.R
import com.example.movieapiapp.databinding.FragmentPopularBinding

class PopularFragment : Fragment() {
    private lateinit var binding: FragmentPopularBinding
    private val popularMovieViewModel: PopularMovieViewModel by viewModels()
    private val popularMovieAdapter: PopularMovieAdapter by lazy {
        PopularMovieAdapter(onClickMovie = { movieId ->
            onClickMovie(movieId)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPopularBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preparePopularMovieRecyclerView()

        popularMovieViewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            showLoadingProgressBar(isLoading)
        }

        popularMovieViewModel.popularMovie
            .observe(viewLifecycleOwner) { popularMovieList ->
                popularMovieAdapter.submitList(popularMovieList)
            }
    }

    private fun preparePopularMovieRecyclerView() {
        binding.rcvPopular.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = popularMovieAdapter
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