package com.guidovezzoni.bingeworthyshow2.domain.model

object ConfigurationDomainModelMother {
    val ANY_CONFIGURATION_DOMAIN_MODEL = ConfigurationDomainModel(
        imageBaseUrl = "https://base.url",
        posterSizes = listOf("w92", "w154", "w185", "w342", "w500", "w780", "original")
    )

    val LOWER_RES_CONFIGURATION_DOMAIN_MODEL = ConfigurationDomainModel(
        imageBaseUrl = "https://base.url",
        posterSizes = listOf("w92", "w154", "w185", "w342", "original")
    )

    val ORIGINAL_CONFIGURATION_DOMAIN_MODEL = ConfigurationDomainModel(
        imageBaseUrl = "https://base.url",
        posterSizes = listOf("original")
    )
}
