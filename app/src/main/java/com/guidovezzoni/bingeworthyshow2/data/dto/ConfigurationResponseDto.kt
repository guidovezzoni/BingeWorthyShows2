package com.guidovezzoni.bingeworthyshow2.data.dto

import com.google.gson.annotations.SerializedName

data class ConfigurationResponseDto(
    @SerializedName("images") val images: ImagesDto,
    @SerializedName("change_keys") val changeKeys: List<String>,
)
