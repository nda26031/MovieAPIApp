package com.example.movieapiapp.ui.data.network

import com.example.movieapiapp.ui.fragments.home.popular.PopularMovieState
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("movie/popular")
    fun getPopularMovieList(
        @Query("api_key") apiKey: String
    ): Call<PopularMovieState>
}