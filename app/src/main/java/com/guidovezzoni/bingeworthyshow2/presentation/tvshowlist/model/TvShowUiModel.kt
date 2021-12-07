package com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model

import com.guidovezzoni.bingeworthyshow2.data.dto.PaginatedResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.TvShowDto

data class TvShowUiModel(
    val id: Long,
    val name: String,
)

fun TvShowDto.toTvShowUiModel() = TvShowUiModel(
    id = id,
    name = name,
)

fun PaginatedResponseDto<TvShowDto>.toPaginatedTvShowList(): PaginatedListUiModel<TvShowUiModel> =
    PaginatedListUiModel(
        items = results.map { it.toTvShowUiModel() },
        page = page,
        totalItems = totalResults,
        totalPages = totalPages,
    )
