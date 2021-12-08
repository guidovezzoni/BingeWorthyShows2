package com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model

import com.guidovezzoni.bingeworthyshow2.data.dto.PaginatedResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.TvShowDto
import com.guidovezzoni.bingeworthyshow2.domain.model.ConfigurationDomainModel
import com.guidovezzoni.bingeworthyshow2.domain.model.getBestPosterSize

data class TvShowUiModel(
    val id: Long,
    val name: String,
    val posterUrl: String,
    val voteAverage: Double?,
)

fun TvShowDto.toTvShowUiModel(config: ConfigurationDomainModel) = TvShowUiModel(
    id = id,
    name = name,
    posterUrl = config.imageBaseUrl + config.getBestPosterSize() + posterPath,
    voteAverage = voteAverage,
)

fun PaginatedResponseDto<TvShowDto>.toPaginatedTvShowList(config: ConfigurationDomainModel) =
    PaginatedListUiModel(
        items = results.map { it.toTvShowUiModel(config) },
        page = page,
        totalItems = totalResults,
        totalPages = totalPages,
    )
