package com.guidovezzoni.bingeworthyshow2.domain.model

import com.guidovezzoni.bingeworthyshow2.data.dto.PaginatedResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.TvShowDto

data class TvShowDomainModel(
    val id: Long,
    val name: String,
    val posterPath: String,
    val voteAverage: Double?,
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
