package com.guidovezzoni.bingeworthyshow2.data.api

import com.guidovezzoni.bingeworthyshow2.data.dto.PaginatedResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.TvShowDto
import retrofit2.http.GET

interface MdbApi {
    @GET("/3/tv/get-top-rated-tv")
    suspend fun getTopRatedShows(): PaginatedResponseDto<TvShowDto>
}
