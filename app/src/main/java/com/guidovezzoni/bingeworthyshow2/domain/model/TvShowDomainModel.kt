package com.guidovezzoni.bingeworthyshow2.domain.model

data class TvShowDomainModel(
    val id: Long,
    val name: String,
    val posterPath: String,
    val voteAverage: Double?,
)
