package com.example.movieapiapp.ui.fragments.home.upcoming

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class UpcomingMovieState (
    val dates: Dates,
    val page: Long,
    val results: List<UpcomingMovie>,

    @SerializedName("total_pages")
    val totalPages: Long,

    @SerializedName("total_results")
    val totalResults: Long
)

@kotlinx.serialization.Serializable
data class Dates (
    val maximum: String,
    val minimum: String
)

@kotlinx.serialization.Serializable
data class UpcomingMovie (
    val adult: Boolean,

    @SerializedName("backdrop_path")
    val backdropPath: String,

    @SerializedName("genre_ids")
    val genreIDS: List<Long>,

    val id: Long,

    @SerializedName("original_language")
    val originalLanguage: OriginalLanguage,

    @SerializedName("original_title")
    val originalTitle: String,

    val overview: String,
    val popularity: Double,

    @SerializedName("poster_path")
    val posterPath: String,

    @SerializedName("release_date")
    val releaseDate: String,

    val title: String,
    val video: Boolean,

    @SerializedName("vote_average")
    val voteAverage: Double,

    @SerializedName("vote_count")
    val voteCount: Long
)

@Serializable
enum class OriginalLanguage(val value: String) {
    @SerializedName("en") En("en"),
    @SerializedName("lv") LV("lv"),
    @SerializedName("zh") Zh("zh");
}