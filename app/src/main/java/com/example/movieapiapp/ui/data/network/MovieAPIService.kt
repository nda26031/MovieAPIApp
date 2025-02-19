package com.example.movieapiapp.ui.data.network

import com.example.movieapiapp.ui.fragments.home.nowplaying.NowPlayingMovieState
import com.example.movieapiapp.ui.fragments.home.popular.PopularMovieState
import com.example.movieapiapp.ui.fragments.home.toprates.TopRatedMovieState
import com.example.movieapiapp.ui.fragments.home.upcoming.UpcomingMovieState
import com.example.movieapiapp.ui.fragments.moviedetail.MovieState
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {
    @GET("movie/popular")
    fun getPopularMovieList(
        @Query("api_key") apiKey: String
    ): Call<PopularMovieState>

    @GET("movie/upcoming")
    fun getUpcomingMovieList(
        @Query("api_key") apiKey: String
    ): Call<UpcomingMovieState>

    @GET("movie/now_playing")
    fun getPlayingMovieList(
        @Query("api_key") apiKey: String
    ): Call<NowPlayingMovieState>

    @GET("movie/now_playing")
    fun getTopRateMovieList(
        @Query("api_key") apiKey: String
    ): Call<TopRatedMovieState>

    @GET("movie/{movie_id}")
    fun getMovieDetail(
        @Path("movie_id") movieId: Long,
        @Query("api_key") apiKey: String
    ): Call<MovieState>

}