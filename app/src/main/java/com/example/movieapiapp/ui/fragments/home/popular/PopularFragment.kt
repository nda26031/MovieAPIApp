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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapiapp.R
import com.example.movieapiapp.ui.data.network.MovieApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PopularFragment : Fragment() {
    private var recyclerView: RecyclerView? = null
    private var popularMovieAdapter: PopularMovieAdapter? = null
    private var popularMovieViewModel: PopularMovieViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.rcvPopular)

        preparePopularMovieRecyclerView()

        popularMovieViewModel = ViewModelProvider(this)[PopularMovieViewModel::class.java]
        popularMovieViewModel?.getPopularMovieList()
        popularMovieViewModel?.observePopularMovieLiveData()
            ?.observe(viewLifecycleOwner, Observer { popularMovieList ->
                popularMovieAdapter?.submitList(popularMovieList)
            })

    }

    private fun preparePopularMovieRecyclerView() {
        popularMovieAdapter = PopularMovieAdapter()
        recyclerView?.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = popularMovieAdapter
        }

    }

}