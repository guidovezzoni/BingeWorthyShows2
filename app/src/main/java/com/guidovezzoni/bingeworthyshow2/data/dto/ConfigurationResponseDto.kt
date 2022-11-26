package com.guidovezzoni.bingeworthyshow2.data.dto

import com.google.gson.annotations.SerializedName
import com.guidovezzoni.bingeworthyshow2.domain.model.ConfigurationDomainModel

data class ConfigurationResponseDto(
    @SerializedName("images") val images: ImagesDto,
    @SerializedName("change_keys") val changeKeys: List<String>,
)

fun ConfigurationResponseDto.toConfigurationDomainModel() =
    ConfigurationDomainModel(
        imageBaseUrl = images.secureBaseUrl,
        posterSizes = images.posterSizes,
    )
