package com.example.movieapiapp.ui.fragments.home.nowplaying

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapiapp.ui.data.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NowPlayingMovieViewModel : ViewModel() {
    private val _nowPlayingMovie = MutableLiveData<List<NowPlayingMovie>>()
    val nowPlayingMovie: LiveData<List<NowPlayingMovie>> = _nowPlayingMovie

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun getNowPlayingMovieList() {
        _loading.value = true
        RetrofitInstance.api.getPlayingMovieList("ccea8d7b622a323de74dbfad8ec0a374")
            .enqueue(object : Callback<NowPlayingMovieState> {
                override fun onResponse(
                    call: Call<NowPlayingMovieState>,
                    response: Response<NowPlayingMovieState>
                ) {
                    if (response.isSuccessful) {
                        _nowPlayingMovie.value = response.body()?.results
                        _loading.value = false
                    }
                }

                override fun onFailure(call: Call<NowPlayingMovieState>, t: Throwable) {
                    Log.d("TAG", t.message.toString())
                }

            })
    }
}