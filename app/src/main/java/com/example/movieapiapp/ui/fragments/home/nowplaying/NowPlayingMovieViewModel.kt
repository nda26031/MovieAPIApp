package com.example.movieapiapp.ui.fragments.home.nowplaying

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

class NowPlayingMovieViewModel : ViewModel() {
    private val _nowPlayingMovie = MutableLiveData<List<NowPlayingMovie>?>()
    val nowPlayingMovie: LiveData<List<NowPlayingMovie>?> = _nowPlayingMovie

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val repository = AppRepository()

    init {
        getNowPlayingMovieList()
    }

    private fun getNowPlayingMovieList() {
        viewModelScope.launch {
            _loading.value = true
            val movies = repository.getNowPlayingMovies()
            _nowPlayingMovie.postValue(movies)
            _loading.postValue(false)
        }
    }
}