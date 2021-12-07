package com.guidovezzoni.bingeworthyshow2.data

import com.guidovezzoni.bingeworthyshow2.api.MdbApi

/**
 * If we need to support local cache here is where we'll implement the required logic
 */
class MdbRepositoryImpl(private val api: MdbApi) : MdbRepository {

    override suspend fun getTopRatedShows() = api.getTopRatedShows()

}
