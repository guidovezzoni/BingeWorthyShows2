package com.guidovezzoni.bingeworthyshow2.data.datasource

import com.guidovezzoni.bingeworthyshow2.data.dto.ConfigurationResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.PaginatedResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.TvShowDto

interface MdbDatasource {

    suspend fun getConfiguration(): ConfigurationResponseDto

    suspend fun getTopRatedShows(): PaginatedResponseDto<TvShowDto>

}
