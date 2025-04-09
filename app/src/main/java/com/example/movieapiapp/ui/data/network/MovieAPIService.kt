package com.example.movieapiapp.ui.data.network

import com.example.movieapiapp.ui.fragments.home.nowplaying.NowPlayingMovieState
import com.example.movieapiapp.ui.fragments.home.popular.PopularMovieState
import com.example.movieapiapp.ui.fragments.home.toprates.TopRatedMovieState
import com.example.movieapiapp.ui.fragments.home.upcoming.UpcomingMovieState
import com.example.movieapiapp.ui.fragments.moviedetail.MovieDetailState
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {
    @GET("movie/popular")
    suspend fun getPopularMovieList(
        @Query("api_key") apiKey: String
    ): Response<PopularMovieState>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovieList(
        @Query("api_key") apiKey: String
    ): Response<UpcomingMovieState>

    @GET("movie/now_playing")
    suspend fun getPlayingMovieList(
        @Query("api_key") apiKey: String
    ): Response<NowPlayingMovieState>

    @GET("movie/top_rated")
    suspend fun getTopRateMovieList(
        @Query("api_key") apiKey: String
    ): Response<TopRatedMovieState>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Long,
        @Query("api_key") apiKey: String
    ): Response<MovieDetailState>

}