package com.example.movieapiapp.ui.fragments.home.upcoming

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapiapp.ui.data.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UpcomingMovieViewModel : ViewModel() {
    private val _upcomingMovie = MutableLiveData<List<UpcomingMovie>>()

    val upcomingMovie : LiveData<List<UpcomingMovie>> = _upcomingMovie

    fun getUpcomingMovieList() {
        RetrofitInstance.api.getUpcomingMovieList("ccea8d7b622a323de74dbfad8ec0a374")
            .enqueue(object : Callback<UpcomingMovieState> {
                override fun onResponse(
                    call: Call<UpcomingMovieState>,
                    response: Response<UpcomingMovieState>
                ) {
                    Log.d("viewModel", "onResponse: ${response.body()}")
                    if (response.body() != null) {
                        _upcomingMovie.value = response.body()?.results
                    }
                }

                override fun onFailure(call: Call<UpcomingMovieState>, t: Throwable) {
                    Log.d("TAG", t.message.toString())

                }
            })
    }

}