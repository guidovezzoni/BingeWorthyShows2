package com.guidovezzoni.bingeworthyshow2.data.datasource

import com.guidovezzoni.bingeworthyshow2.data.dto.PaginatedResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.TvShowDto

interface MdbDatasource {

    suspend fun getTopRatedShows(): PaginatedResponseDto<TvShowDto>

}
