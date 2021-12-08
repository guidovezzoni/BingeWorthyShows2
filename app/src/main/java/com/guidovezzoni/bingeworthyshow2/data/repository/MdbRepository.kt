package com.guidovezzoni.bingeworthyshow2.data.repository

import com.guidovezzoni.bingeworthyshow2.data.dto.ConfigurationResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.PaginatedResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.TvShowDto

interface MdbRepository {

    suspend fun getConfiguration(): ConfigurationResponseDto

    suspend fun getTopRatedShows(page: Int): PaginatedResponseDto<TvShowDto>

}
