package com.example.movieapiapp.ui.fragments.home.popular

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapiapp.ui.data.repository.AppRepository
import com.example.movieapiapp.ui.data.utils.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularMovieViewModel : ViewModel() {
    private val _popularMovie = MutableLiveData<List<PopularMovie>?>()
    val popularMovie: MutableLiveData<List<PopularMovie>?> = _popularMovie

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val repository = AppRepository()

    init {
        getPopularMovieList()
    }

    private fun getPopularMovieList() {
        viewModelScope.launch {
            _loading.value = true
            val movies = repository.getPopularMovies()
            _popularMovie.postValue(movies)
            _loading.postValue(false)
        }
    }
}