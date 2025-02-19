package com.example.movieapiapp.ui.fragments.home.popular

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapiapp.R
import com.example.movieapiapp.databinding.FragmentPopularBinding
import com.example.movieapiapp.ui.data.network.MovieApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PopularFragment : Fragment() {
    private lateinit var binding: FragmentPopularBinding
    private var popularMovieAdapter: PopularMovieAdapter? = null
    private val popularMovieViewModel: PopularMovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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

        popularMovieViewModel.getPopularMovieList()
        popularMovieViewModel.popularMovie
            .observe(viewLifecycleOwner) { popularMovieList ->
                popularMovieAdapter?.submitList(popularMovieList)
            }

    }

    private fun preparePopularMovieRecyclerView() {
        popularMovieAdapter = PopularMovieAdapter()
        binding.rcvPopular.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = popularMovieAdapter
        }
    }

    private fun showLoadingProgressBar(isLoading: Boolean) {
        binding.pbLoading.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

}