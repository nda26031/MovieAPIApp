package com.example.movieapiapp.ui.fragments.moviedetail

import android.graphics.Movie
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapiapp.ui.data.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailViewModel : ViewModel() {
    private val _movieDetail = MutableLiveData<MovieDetailState>()
    val movieDetail: LiveData<MovieDetailState> = _movieDetail

    fun getMovieDetail() {
        RetrofitInstance.api.getMovieDetail(
            _movieDetail.value!!.id,
            "ccea8d7b622a323de74dbfad8ec0a374"
        ).enqueue(object : Callback<MovieDetailState> {
            override fun onResponse(
                call: Call<MovieDetailState>,
                response: Response<MovieDetailState>
            ) {
                if (response.isSuccessful) {
                    Log.d("viewModel", "onResponse: ${response.body()}")
                    _movieDetail.value = response.body()
                }
            }

            override fun onFailure(call: Call<MovieDetailState>, t: Throwable) {
                Log.d("viewModel", t.message.toString())
            }
        })

    }
}