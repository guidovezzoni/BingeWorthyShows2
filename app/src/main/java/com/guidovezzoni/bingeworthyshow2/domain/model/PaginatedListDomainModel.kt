package com.guidovezzoni.bingeworthyshow2.domain.model

/**
 * This has been kept general as it's likely to be used in similar responses
 */
data class PaginatedListDomainModel<T>(
    val items: List<T>,
    val page: Long,
    val totalItems: Long,
    val totalPages: Long,
)
