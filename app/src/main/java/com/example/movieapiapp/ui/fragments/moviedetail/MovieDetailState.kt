package com.example.movieapiapp.ui.fragments.moviedetail

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable
data class MovieDetailState (
    val adult: Boolean,

    @SerializedName("backdrop_path")
    val backdropPath: String,

    @SerializedName("belongs_to_collection")
    val belongsToCollection: JsonElement? = null,

    val budget: Long,
    val genres: List<Genre>,
    val homepage: String,
    val id: Long,

    @SerializedName("imdb_id")
    val imdbID: String,

    @SerializedName("origin_country")
    val originCountry: List<String>,

    @SerializedName("original_language")
    val originalLanguage: String,

    @SerializedName("original_title")
    val originalTitle: String,

    val overview: String,
    val popularity: Double,

    @SerializedName("poster_path")
    val posterPath: String,

    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany>,

    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountry>,

    @SerializedName("release_date")
    val releaseDate: String,

    val revenue: Long,
    val runtime: Long,

    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>,

    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,

    @SerializedName("vote_average")
    val voteAverage: Double,

    @SerializedName("vote_count")
    val voteCount: Long
)

@Serializable
data class Genre (
    val id: Long,
    val name: String
)

@Serializable
data class ProductionCompany (
    val id: Long,

    @SerializedName("logo_path")
    val logoPath: String? = null,

    val name: String,

    @SerializedName("origin_country")
    val originCountry: String
)

@Serializable
data class ProductionCountry (
    @SerializedName("iso_3166_1")
    val iso3166_1: String,

    val name: String
)

@Serializable
data class SpokenLanguage (
    @SerializedName("english_name")
    val englishName: String,

    @SerializedName("iso_639_1")
    val iso639_1: String,

    val name: String
)
