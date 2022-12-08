package com.guidovezzoni.bingeworthyshow2.data.datasource

import com.guidovezzoni.bingeworthyshow2.data.api.MdbApi
import com.guidovezzoni.bingeworthyshow2.data.dto.ConfigurationResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.PaginatedResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.TvShowDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MdbRestDatasource(private val api: MdbApi, private val apiKey: String) : MdbDatasource {

    override suspend fun getConfiguration2(): Flow<ConfigurationResponseDto> = flow {
        val configurationValue: ConfigurationResponseDto = api.getConfiguration(apiKey)
        emit(configurationValue)
    } // .flowOn(Dispatchers.IO)

    override suspend fun getTopRatedShows2(page: Int): Flow<PaginatedResponseDto<TvShowDto>> = flow {
        val topRatedShowsValue = api.getTopRatedShows(apiKey, page)
        emit(topRatedShowsValue)
    } // .flowOn(Dispatchers.IO)

    @Deprecated("to be replaced by flow")
    override suspend fun getConfiguration(): ConfigurationResponseDto = api.getConfiguration(apiKey)

    @Deprecated("to be replaced by flow")
    override suspend fun getTopRatedShows(page: Int): PaginatedResponseDto<TvShowDto> =
        api.getTopRatedShows(apiKey, page)
}
