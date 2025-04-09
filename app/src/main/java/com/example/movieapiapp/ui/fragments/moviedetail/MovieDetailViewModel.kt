package com.example.movieapiapp.ui.fragments.moviedetail

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

class MovieDetailViewModel : ViewModel() {
    private val _movieDetail = MutableLiveData<MovieDetailState?>()
    val movieDetail: MutableLiveData<MovieDetailState?> = _movieDetail

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val repository = AppRepository()

    fun getMovieDetail(movieId: Long) {
        viewModelScope.launch {
            _loading.value = true
            val movieDetail = repository.getMovieDetail(movieId)
            _movieDetail.value = movieDetail
            _loading.value = false
        }

    }
}