package com.guidovezzoni.bingeworthyshow2.data.repository

import com.guidovezzoni.bingeworthyshow2.data.datasource.MdbRestDatasource
import com.guidovezzoni.bingeworthyshow2.data.dto.ConfigurationResponseDto

/**
 * If we need to support local cache here is where we'll implement the required logic
 */
class MdbRepositoryImpl(private val mdbRestDatasource: MdbRestDatasource) : MdbRepository {

    private var inMemoryCache: ConfigurationResponseDto? = null

    /**
     * Configuration is cached in memory. TMDB's recommendations are to refresh the cache every few
     * days, so an improvement would be to implement a more persistent cache, f.i. in SharedPrefs
     */
    override suspend fun getConfiguration(): ConfigurationResponseDto {
        val currentConfig = inMemoryCache
        return if (currentConfig != null) {
            currentConfig
        } else {
            val newConfiguration = mdbRestDatasource.getConfiguration()
            inMemoryCache = newConfiguration
            newConfiguration
        }
    }

    override suspend fun getTopRatedShows(page: Int) = mdbRestDatasource.getTopRatedShows(page)

}
