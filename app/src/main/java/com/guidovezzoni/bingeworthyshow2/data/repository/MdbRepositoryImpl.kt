package com.guidovezzoni.bingeworthyshow2.data.repository

import com.guidovezzoni.bingeworthyshow2.data.datasource.MdbRestDatasource
import com.guidovezzoni.bingeworthyshow2.data.dto.ConfigurationResponseDto
import com.guidovezzoni.bingeworthyshow2.domain.repository.MdbRepository
import io.reactivex.rxjava3.core.Observable

/**
 * If we need to support local cache here is where we'll implement the required logic
 */
class MdbRepositoryImpl(private val mdbRestDatasource: MdbRestDatasource) : MdbRepository {

    private var inMemoryCache: ConfigurationResponseDto? = null

    /**
     * Configuration is cached in memory. TMDB's recommendations are to refresh the cache every few
     * days, so an improvement would be to implement a more persistent cache, f.i. in SharedPrefs
     */
    override fun getConfiguration(): Observable<ConfigurationResponseDto> {
        val currentConfig = inMemoryCache

        return if (currentConfig != null) {
            Observable.just(currentConfig)
        } else {
            mdbRestDatasource.getConfiguration()
                .doOnNext { config -> inMemoryCache = config }
        }
    }

    override fun getTopRatedShows(page: Int) = mdbRestDatasource.getTopRatedShows(page)
}
