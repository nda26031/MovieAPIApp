package com.example.movieapiapp.ui.fragments.home.upcoming

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapiapp.databinding.FragmentUpComingBinding


class UpComingFragment : Fragment() {

    private lateinit var binding: FragmentUpComingBinding
    private val upcomingMovieViewModel: UpcomingMovieViewModel by viewModels()
    private var upcomingMovieAdapter = UpcomingMovieAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUpComingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prepareRecyclerView()

        upcomingMovieViewModel.getUpcomingMovieList()
        upcomingMovieViewModel.upcomingMovie
            .observe(viewLifecycleOwner) { upcomingMovieList ->
                upcomingMovieAdapter.submitList(upcomingMovieList)
                binding.rcvUpcoming.adapter = upcomingMovieAdapter
            }
    }

    private fun prepareRecyclerView() {
        upcomingMovieAdapter = UpcomingMovieAdapter()
        binding.rcvUpcoming.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = upcomingMovieAdapter
        }
    }




}