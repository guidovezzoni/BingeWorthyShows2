package com.guidovezzoni.bingeworthyshow2.data.api

import com.guidovezzoni.bingeworthyshow2.data.dto.PaginatedResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.TvShowDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MdbApi {

    // top-rated endpoint doesn't seem to work for some reason so I'm using the popular endpoint
    //@GET("/3/tv/top-rated")
    @GET("/3/tv/popular")
    suspend fun getTopRatedShows(@Query("api_key") apiKey: String):
            PaginatedResponseDto<TvShowDto>
}
