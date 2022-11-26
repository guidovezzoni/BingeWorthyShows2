package com.guidovezzoni.bingeworthyshow2.data.dto

import com.google.gson.annotations.SerializedName
import com.guidovezzoni.bingeworthyshow2.domain.model.PaginatedListDomainModel
import com.guidovezzoni.bingeworthyshow2.domain.model.TvShowDomainModel

data class TvShowDto(
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("id") val id: Long,
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("vote_average") val voteAverage: Double?,
    @SerializedName("overview") val overview: String,
    @SerializedName("first_air_date") val firstAirDate: String,
    @SerializedName("origin_country") val originCountry: List<String>,
    @SerializedName("genre_ids") val genreIds: List<Long>,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("vote_count") val voteCount: Long,
    @SerializedName("name") val name: String,
    @SerializedName("original_name") val originalName: String,
)

fun TvShowDto.toTvShowDomainModel() = TvShowDomainModel(
    id = id,
    name = name,
    posterPath = posterPath.orEmpty(),
    voteAverage = voteAverage,
)

fun PaginatedResponseDto<TvShowDto>.toPaginatedTvShowList() =
    PaginatedListDomainModel(
        items = results.map { it.toTvShowDomainModel() },
        page = page,
        totalItems = totalResults,
        totalPages = totalPages,
    )
