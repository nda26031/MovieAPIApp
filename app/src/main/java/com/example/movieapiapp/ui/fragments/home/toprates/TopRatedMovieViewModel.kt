package com.example.movieapiapp.ui.fragments.home.toprates

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapiapp.ui.data.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopRatedMovieViewModel : ViewModel() {
    private var _topRatedMovie = MutableLiveData<List<TopRatedMovie>>()
    val topRatedMovie: LiveData<List<TopRatedMovie>> = _topRatedMovie

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun getPopularMovies() {
        _loading.value = true

        RetrofitInstance.api.getTopRateMovieList("69d66957eebff9666ea46bd464773cf0")
            .enqueue(object :
                Callback<TopRatedMovieState> {
                override fun onResponse(
                    call: Call<TopRatedMovieState>,
                    response: Response<TopRatedMovieState>
                ) {
                    if (response.body() != null) {
                        _topRatedMovie.value = response.body()!!.results
                        _loading.value = false

                    }
                }

                override fun onFailure(call: Call<TopRatedMovieState>, t: Throwable) {
                    Log.d("TAG", t.message.toString())
                }
            })
    }

}