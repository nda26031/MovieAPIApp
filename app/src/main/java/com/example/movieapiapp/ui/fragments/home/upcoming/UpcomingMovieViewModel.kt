package com.example.movieapiapp.ui.fragments.home.upcoming

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapiapp.ui.data.repository.AppRepository
import kotlinx.coroutines.launch

class UpcomingMovieViewModel : ViewModel() {
    private val _upcomingMovie = MutableLiveData<List<UpcomingMovie>?>()
    val upcomingMovie: MutableLiveData<List<UpcomingMovie>?> = _upcomingMovie

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val repository = AppRepository()

    init {
        getUpcomingMovieList()
    }

    private fun getUpcomingMovieList() {
        viewModelScope.launch {
            _loading.value = true
            val movies = repository.getUpcomingMovies()
            _upcomingMovie.value = movies
            _loading.value = false
        }
    }

}