package com.guidovezzoni.bingeworthyshow2.data.datasource

import com.guidovezzoni.bingeworthyshow2.data.dto.ConfigurationResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.PaginatedResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.TvShowDto
import kotlinx.coroutines.flow.Flow

interface MdbDatasource {
    suspend fun getConfiguration2(): Flow<ConfigurationResponseDto>

    suspend fun getTopRatedShows2(page: Int): Flow<PaginatedResponseDto<TvShowDto>>

    @Deprecated("to be replaced by flow")
    suspend fun getConfiguration(): ConfigurationResponseDto

    @Deprecated("to be replaced by flow")
    suspend fun getTopRatedShows(page: Int): PaginatedResponseDto<TvShowDto>
}
