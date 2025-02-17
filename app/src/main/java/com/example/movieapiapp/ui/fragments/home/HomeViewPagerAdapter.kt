package com.example.movieapiapp.ui.fragments.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.movieapiapp.ui.fragments.home.allmovie.AllMovieFragment
import com.example.movieapiapp.ui.fragments.home.nowplaying.NowPlayingFragment
import com.example.movieapiapp.ui.fragments.home.popular.PopularFragment
import com.example.movieapiapp.ui.fragments.home.toprates.TopRatesFragment
import com.example.movieapiapp.ui.fragments.home.upcoming.UpComingFragment


class HomeViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AllMovieFragment()
            1 -> PopularFragment()
            2 -> NowPlayingFragment()
            3 -> UpComingFragment()
            4 -> TopRatesFragment()
            else -> {
                AllMovieFragment()
            }
        }
    }

}