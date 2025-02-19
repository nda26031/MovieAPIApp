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
    private var popularMovieLiveData = MutableLiveData<List<PopularMovie>>()

    fun getPopularMovieList() {
        RetrofitInstance.api.getPopularMovieList("ccea8d7b622a323de74dbfad8ec0a374")
            .enqueue(object : Callback<PopularMovieState> {
                override fun onResponse(
                    call: Call<PopularMovieState>,
                    response: Response<PopularMovieState>
                ) {
                    if (response.body() != null) {
                        Log.d("TAG", response.body()!!.results.toString())
                        popularMovieLiveData.value = response.body()?.results
                    }
                }

                override fun onFailure(call: Call<PopularMovieState>, t: Throwable) {
                    Log.d("TAG", t.message.toString())
                }
            })
    }

    fun observePopularMovieLiveData(): LiveData<List<PopularMovie>> {
        return popularMovieLiveData
    }
}