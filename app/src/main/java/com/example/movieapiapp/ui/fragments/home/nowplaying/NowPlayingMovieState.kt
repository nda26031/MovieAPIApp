package com.example.movieapiapp.ui.fragments.home.nowplaying

import kotlinx.serialization.*

@Serializable
data class NowPlayingMovieState (
    val dates: Dates,
    val page: Long,
    val results: List<NowPlayingMovie>,

    @SerialName("total_pages")
    val totalPages: Long,

    @SerialName("total_results")
    val totalResults: Long
)

@Serializable
data class Dates (
    val maximum: String,
    val minimum: String
)

@Serializable
data class NowPlayingMovie (
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
    @SerialName("fr") Fr("fr"),
    @SerialName("th") Th("th"),
    @SerialName("zh") Zh("zh");
}