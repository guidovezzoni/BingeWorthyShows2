package com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model

/**
 * This has been kept general as it's likely to be used in similar situations
 */
data class PaginatedListUiModel<T>(
    val items: List<T>,
    val page: Long,
    val totalItems: Long,
    val totalPages: Long,
)
