package com.guidovezzoni.bingeworthyshow2.domain.model

import com.guidovezzoni.bingeworthyshow2.data.dto.ConfigurationResponseDto

data class ConfigurationDomainModel(
    val imageBaseUrl: String,
    val posterSizes: List<String>,
)

fun ConfigurationResponseDto.toConfigurationDomainModel() =
    ConfigurationDomainModel(
        imageBaseUrl = images.secureBaseUrl,
        posterSizes = images.posterSizes
    )
