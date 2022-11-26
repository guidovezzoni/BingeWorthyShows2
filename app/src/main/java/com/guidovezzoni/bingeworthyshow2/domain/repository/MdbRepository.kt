package com.guidovezzoni.bingeworthyshow2.domain.repository

import com.guidovezzoni.bingeworthyshow2.domain.model.ConfigurationDomainModel
import com.guidovezzoni.bingeworthyshow2.domain.model.PaginatedListDomainModel
import com.guidovezzoni.bingeworthyshow2.domain.model.TvShowDomainModel

interface MdbRepository {

    suspend fun getConfiguration(): ConfigurationDomainModel

    suspend fun getTopRatedShows(page: Int): PaginatedListDomainModel<TvShowDomainModel>

}
