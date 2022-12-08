package com.guidovezzoni.bingeworthyshow2.domain.repository

import com.guidovezzoni.bingeworthyshow2.data.dto.ConfigurationResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.PaginatedResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.TvShowDto
import com.guidovezzoni.bingeworthyshow2.domain.model.ConfigurationDomainModel
import com.guidovezzoni.bingeworthyshow2.domain.model.PaginatedListDomainModel
import com.guidovezzoni.bingeworthyshow2.domain.model.TvShowDomainModel
import kotlinx.coroutines.flow.Flow

interface MdbRepository {
    suspend fun getConfiguration2(): Flow<ConfigurationDomainModel>

    suspend fun getTopRatedShows2(page: Int): Flow<PaginatedListDomainModel<TvShowDomainModel>>

    @Deprecated("to be replaced by flow")
    suspend fun getConfiguration(): ConfigurationDomainModel

    @Deprecated("to be replaced by flow")
    suspend fun getTopRatedShows(page: Int): PaginatedListDomainModel<TvShowDomainModel>
}
