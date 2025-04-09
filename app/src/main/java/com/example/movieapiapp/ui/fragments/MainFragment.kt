package com.example.movieapiapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.movieapiapp.R
import com.example.movieapiapp.ui.fragments.account.AccountFragment
import com.example.movieapiapp.ui.fragments.genre.GenreFragment
import com.example.movieapiapp.ui.fragments.home.HomeFragment
import com.example.movieapiapp.ui.fragments.search.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainFragment : Fragment() {

    private lateinit var bottomNav: BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        loadFragment(HomeFragment())
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomNav = view.findViewById(R.id.bottom_nav)
        bottomNav.setOnItemSelectedListener {item ->
            when (item.itemId) {
                R.id.homeIcon -> {
                    Log.d("TAG", "on click Home")
                    loadFragment(HomeFragment())
                    true
                }

                R.id.searchIcon -> {
                    Log.d("TAG", "on click Search")
                    loadFragment(SearchFragment())
                    true
                }

                R.id.genreIcon -> {
                    Log.d("TAG", "on click Genre")
                    loadFragment(GenreFragment())
                    true
                }

                R.id.accountIcon -> {
                    Log.d("TAG", "on click Genre")
                    loadFragment(AccountFragment())
                    true

                }

                else ->false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container_main, fragment)
        transaction.commit()
    }


}