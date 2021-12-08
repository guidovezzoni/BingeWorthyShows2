package com.guidovezzoni.bingeworthyshow2.domain.model

private const val SIZE_FAVOURITE = "w780"
private const val SIZE_ORIGINAL = "original"

/**
 * Returns the appropriate poster size. The favourite is preferred if present, otherwise the highest
 * resolution and failing that the original - we are assuming original is always present
 */
fun ConfigurationDomainModel.getBestPosterSize(): String = when {
    this.posterSizes.contains(SIZE_FAVOURITE) -> SIZE_FAVOURITE
    this.posterSizes.size > 1 -> this.posterSizes[this.posterSizes.size - 2]
    else -> SIZE_ORIGINAL
}
