package com.guidovezzoni.bingeworthyshow2.data

import com.guidovezzoni.bingeworthyshow2.data.dto.PaginatedResponse
import com.guidovezzoni.bingeworthyshow2.data.dto.TvShowDto

interface MdbRepository {

    suspend fun getTopRatedShows(): PaginatedResponse<TvShowDto>

}