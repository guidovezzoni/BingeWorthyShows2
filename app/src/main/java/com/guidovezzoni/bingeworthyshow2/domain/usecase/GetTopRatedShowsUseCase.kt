package com.guidovezzoni.bingeworthyshow2.domain.usecase

import com.guidovezzoni.bingeworthyshow2.domain.model.PaginatedListDomainModel
import com.guidovezzoni.bingeworthyshow2.domain.model.TvShowDomainModel
import com.guidovezzoni.bingeworthyshow2.domain.repository.MdbRepository
import kotlinx.coroutines.flow.Flow

class GetTopRatedShowsUseCase(private val repository: MdbRepository) {
    @Deprecated("to be replaced by flow")
    suspend operator fun invoke(page: Int): PaginatedListDomainModel<TvShowDomainModel> =
        repository.getTopRatedShows(page)

    suspend fun invoke2(page: Int): Flow<PaginatedListDomainModel<TvShowDomainModel>> =
        repository.getTopRatedShows2(page)
}
