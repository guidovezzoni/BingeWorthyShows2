package com.guidovezzoni.bingeworthyshow2.data.dto

import com.google.gson.annotations.SerializedName

data class PaginatedResponse<T>(
    @SerializedName("page") val page: Long,
    @SerializedName("results") val results: List<T>,
    @SerializedName("total_results") val totalResults: Long,
    @SerializedName("total_pages") val totalPages: Long,
)
