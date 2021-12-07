package com.guidovezzoni.bingeworthyshow2.data.repository

import com.guidovezzoni.bingeworthyshow2.data.datasource.MdbRestDatasource

/**
 * If we need to support local cache here is where we'll implement the required logic
 */
class MdbRepositoryImpl(private val mdbRestDatasource: MdbRestDatasource) : MdbRepository {

    override suspend fun getTopRatedShows() = mdbRestDatasource.getTopRatedShows()

}
