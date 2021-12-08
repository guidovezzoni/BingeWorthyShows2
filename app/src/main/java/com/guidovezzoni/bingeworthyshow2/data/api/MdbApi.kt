package com.guidovezzoni.bingeworthyshow2.data.api

import com.guidovezzoni.bingeworthyshow2.data.dto.ConfigurationResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.PaginatedResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.TvShowDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MdbApi {
    @GET("/3/configuration")
    suspend fun getConfiguration(@Query("api_key") apiKey: String): ConfigurationResponseDto

    @GET("/3/tv/top_rated")
    suspend fun getTopRatedShows(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int,
    ): PaginatedResponseDto<TvShowDto>
}
