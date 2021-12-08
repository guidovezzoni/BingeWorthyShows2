package com.guidovezzoni.bingeworthyshow2.data.api

import com.guidovezzoni.bingeworthyshow2.data.dto.ConfigurationResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.PaginatedResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.TvShowDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MdbApi {
    @GET("/3/configuration")
    suspend fun getConfiguration(@Query("api_key") apiKey: String): ConfigurationResponseDto

    // top-rated endpoint doesn't seem to work for some reason so I'm using the /popular endpoint,
    // which has an identical structure
    //@GET("/3/tv/top-rated")
    @GET("/3/tv/popular")
    suspend fun getTopRatedShows(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int,
    ): PaginatedResponseDto<TvShowDto>
}
