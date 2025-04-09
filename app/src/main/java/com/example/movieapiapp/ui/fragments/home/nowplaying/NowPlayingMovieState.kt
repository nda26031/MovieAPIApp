package com.example.movieapiapp.ui.fragments.home.nowplaying

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.*

@Serializable
data class NowPlayingMovieState (
    val dates: Dates,
    val page: Long,
    val results: List<NowPlayingMovie>,

    @SerializedName("total_pages")
    val totalPages: Long,

    @SerializedName("total_results")
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
    @SerializedName("fr") Fr("fr"),
    @SerializedName("th") Th("th"),
    @SerializedName("zh") Zh("zh");
}