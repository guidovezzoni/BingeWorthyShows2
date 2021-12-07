package com.guidovezzoni.bingeworthyshow2.api

import com.guidovezzoni.bingeworthyshow2.data.dto.PaginatedResponse
import com.guidovezzoni.bingeworthyshow2.data.dto.TvShowDto
import retrofit2.http.GET

interface MdbApi {
    @GET("/3/tv/get-top-rated-tv")
    suspend fun getTopRatedShows(): PaginatedResponse<TvShowDto>
}
