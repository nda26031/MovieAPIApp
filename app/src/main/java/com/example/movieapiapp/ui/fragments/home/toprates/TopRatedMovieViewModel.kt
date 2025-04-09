package com.example.movieapiapp.ui.fragments.home.toprates

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapiapp.ui.data.repository.AppRepository
import kotlinx.coroutines.launch

class TopRatedMovieViewModel : ViewModel() {
    private var _topRatedMovie = MutableLiveData<List<TopRatedMovie>?>()
    val topRatedMovie: MutableLiveData<List<TopRatedMovie>?> = _topRatedMovie

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val repo = AppRepository()

    init {
        getTopRatedMovieList()
    }

    private fun getTopRatedMovieList() {
        viewModelScope.launch {
            _loading.value = true
            val movies = repo.getTopRatedMovies()
            _topRatedMovie.value = movies
            _loading.value = false
        }

    }

}