package com.example.movieapiapp.ui.fragments.home.popular

import android.graphics.Movie
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapiapp.ui.data.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularMovieViewModel : ViewModel() {
    private val _popularMovie = MutableLiveData<List<PopularMovie>>()
    val popularMovie: LiveData<List<PopularMovie>> = _popularMovie

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun getPopularMovieList() {
        _loading.value = true

        RetrofitInstance.api.getPopularMovieList("ccea8d7b622a323de74dbfad8ec0a374")
            .enqueue(object : Callback<PopularMovieState> {
                override fun onResponse(
                    call: Call<PopularMovieState>,
                    response: Response<PopularMovieState>
                ) {
                    if (response.body() != null) {
                        Log.d("viewModel", response.body()!!.results.toString())
                        _popularMovie.value = response.body()?.results
                        _loading.value = false

                    }
                }

                override fun onFailure(call: Call<PopularMovieState>, t: Throwable) {
                    Log.d("TAG", t.message.toString())
                }
            })
    }
}