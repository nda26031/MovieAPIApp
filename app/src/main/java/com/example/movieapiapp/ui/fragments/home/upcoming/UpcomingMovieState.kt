package com.example.movieapiapp.ui.fragments.home.upcoming

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class UpcomingMovieState (
    val dates: Dates,
    val page: Long,
    val results: List<UpcomingMovie>,

    @SerialName("total_pages")
    val totalPages: Long,

    @SerialName("total_results")
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

    @SerialName("backdrop_path")
    val backdropPath: String,

    @SerialName("genre_ids")
    val genreIDS: List<Long>,

    val id: Long,

    @SerialName("original_language")
    val originalLanguage: OriginalLanguage,

    @SerialName("original_title")
    val originalTitle: String,

    val overview: String,
    val popularity: Double,

    @SerialName("poster_path")
    val posterPath: String,

    @SerialName("release_date")
    val releaseDate: String,

    val title: String,
    val video: Boolean,

    @SerialName("vote_average")
    val voteAverage: Double,

    @SerialName("vote_count")
    val voteCount: Long
)

@Serializable
enum class OriginalLanguage(val value: String) {
    @SerialName("en") En("en"),
    @SerialName("lv") LV("lv"),
    @SerialName("zh") Zh("zh");
}