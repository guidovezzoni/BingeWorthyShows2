package com.guidovezzoni.bingeworthyshow2.data.repository

import com.guidovezzoni.bingeworthyshow2.data.datasource.MdbRestDatasource
import com.guidovezzoni.bingeworthyshow2.data.dto.ConfigurationResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.toConfigurationDomainModel
import com.guidovezzoni.bingeworthyshow2.data.dto.toPaginatedTvShowList
import com.guidovezzoni.bingeworthyshow2.domain.model.ConfigurationDomainModel
import com.guidovezzoni.bingeworthyshow2.domain.model.PaginatedListDomainModel
import com.guidovezzoni.bingeworthyshow2.domain.model.TvShowDomainModel
import com.guidovezzoni.bingeworthyshow2.domain.repository.MdbRepository

/**
 * If we need to support local cache here is where we'll implement the required logic
 */
class MdbRepositoryImpl(private val mdbRestDatasource: MdbRestDatasource) : MdbRepository {

    private var inMemoryCache: ConfigurationResponseDto? = null

    /**
     * Configuration is cached in memory. TMDB's recommendations are to refresh the cache every few
     * days, so an improvement would be to implement a more persistent cache, f.i. in SharedPrefs
     */
    override suspend fun getConfiguration(): ConfigurationDomainModel {
        val currentConfig = inMemoryCache
        val model: ConfigurationResponseDto = if (currentConfig != null) {
            currentConfig
        } else {
            val newConfiguration = mdbRestDatasource.getConfiguration()
            inMemoryCache = newConfiguration
            newConfiguration
        }
        return model.toConfigurationDomainModel()
    }

    override suspend fun getTopRatedShows(page: Int): PaginatedListDomainModel<TvShowDomainModel> =
        mdbRestDatasource.getTopRatedShows(page).toPaginatedTvShowList()

}
