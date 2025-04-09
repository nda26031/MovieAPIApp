package com.example.movieapiapp.ui.data.repository

import android.util.Log
import com.example.movieapiapp.BuildConfig
import com.example.movieapiapp.ui.data.utils.RetrofitInstance
import com.example.movieapiapp.ui.fragments.home.nowplaying.NowPlayingMovie
import com.example.movieapiapp.ui.fragments.home.popular.PopularMovie
import com.example.movieapiapp.ui.fragments.home.toprates.TopRatedMovie
import com.example.movieapiapp.ui.fragments.home.upcoming.UpcomingMovie
import com.example.movieapiapp.ui.fragments.moviedetail.MovieDetailState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppRepository {

    suspend fun getUpcomingMovies(): List<UpcomingMovie>? {
        return withContext(Dispatchers.IO) {
            try {
                val response = RetrofitInstance.api.getUpcomingMovieList(BuildConfig.API_KEY)
                if (response.isSuccessful) {
                    response.body()?.results
                } else {
                    Log.e("Repository", "Error: ${response.message()}")
                    null
                }
            } catch (e: Exception) {
                Log.e("Repository", "Exception: ${e.message}")
                null
            }
        }
    }

    suspend fun getTopRatedMovies(): List<TopRatedMovie>? {
        return withContext(Dispatchers.IO) {
            try {
                val response = RetrofitInstance.api.getTopRateMovieList(BuildConfig.API_KEY)
                if (response.isSuccessful) {
                    Log.e("Repository", "Success: ${response.body()}")
                    response.body()?.results
                } else {
                    Log.e("Repository", "Error: ${response.message()}")
                    null
                }
            } catch (e: Exception) {
                Log.e("Repository", "Exception: ${e.message}")
                null
            }
        }
    }

    suspend fun getPopularMovies(): List<PopularMovie>? {
        return withContext(Dispatchers.IO) {
            try {
                val response = RetrofitInstance.api.getPopularMovieList(BuildConfig.API_KEY)
                if (response.isSuccessful) {
                    response.body()?.results
                } else {
                    null
                }
            } catch (e: Exception) {
                Log.e("Repository", "Exception: ${e.message}")
                null
            }
        }
    }

    suspend fun getNowPlayingMovies(): List<NowPlayingMovie>? {
        return withContext(Dispatchers.IO) {
            try {
                val response = RetrofitInstance.api.getPlayingMovieList(BuildConfig.API_KEY)
                if (response.isSuccessful) {
                    response.body()?.results
                } else {
                    null
                }
            } catch (e: Exception) {
                Log.e("Repository", "Exception: ${e.message}")
                null
            }
        }
    }

    suspend fun getMovieDetail(movieId: Long): MovieDetailState? {
        return withContext(Dispatchers.IO) {
            try {
                val response = RetrofitInstance.api.getMovieDetail(movieId, BuildConfig.API_KEY)
                if (response.isSuccessful) {
                    response.body()
                } else {
                    null
                }
            } catch (e: Exception) {
                Log.e("Repository", "Exception: ${e.message}")
                null
            }
        }
    }


}