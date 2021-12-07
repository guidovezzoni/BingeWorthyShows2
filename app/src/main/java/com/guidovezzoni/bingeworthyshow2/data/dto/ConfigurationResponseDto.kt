package com.guidovezzoni.bingeworthyshow2.data.dto

import com.google.gson.annotations.SerializedName

data class ConfigurationResponseDto(
    @SerializedName("images") val images: Images,
    @SerializedName("change_keys") val changeKeys: List<String>,
)
