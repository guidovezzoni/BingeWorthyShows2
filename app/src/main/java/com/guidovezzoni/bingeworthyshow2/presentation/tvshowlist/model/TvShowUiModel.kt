package com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model

import com.guidovezzoni.bingeworthyshow2.domain.model.ConfigurationDomainModel
import com.guidovezzoni.bingeworthyshow2.domain.model.PaginatedListDomainModel
import com.guidovezzoni.bingeworthyshow2.domain.model.TvShowDomainModel
import com.guidovezzoni.bingeworthyshow2.domain.model.getBestPosterSize

data class TvShowUiModel(
    val id: Long,
    val name: String,
    val posterUrl: String,
    val voteAverage: Double?,
)

fun TvShowDomainModel.toTvShowUiModel(config: ConfigurationDomainModel) = TvShowUiModel(
    id = id,
    name = name,
    posterUrl = config.imageBaseUrl + config.getBestPosterSize() + posterPath,
    voteAverage = voteAverage,
)

fun PaginatedListDomainModel<TvShowDomainModel>.toPaginatedTvShowList(
    config: ConfigurationDomainModel,
) = PaginatedListUiModel(
    items = items.map { it.toTvShowUiModel(config) },
    page = page,
    totalItems = totalItems,
    totalPages = totalPages,
)
