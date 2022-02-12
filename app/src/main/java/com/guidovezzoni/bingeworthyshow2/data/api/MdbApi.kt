package com.guidovezzoni.bingeworthyshow2.data.api

import com.guidovezzoni.bingeworthyshow2.data.dto.ConfigurationResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.PaginatedResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.TvShowDto
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MdbApi {
    @GET("/3/configuration")
    fun getConfiguration(@Query("api_key") apiKey: String): Observable<ConfigurationResponseDto>

    @GET("/3/tv/top_rated")
    fun getTopRatedShows(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int,
    ): Observable<PaginatedResponseDto<TvShowDto>>
}
