package com.guidovezzoni.bingeworthyshow2.domain.usecase

import com.guidovezzoni.bingeworthyshow2.domain.model.PaginatedListDomainModel
import com.guidovezzoni.bingeworthyshow2.domain.model.TvShowDomainModel
import com.guidovezzoni.bingeworthyshow2.domain.repository.MdbRepository

class GetTopRatedShowsUseCase(private val repository: MdbRepository) {

    suspend operator fun invoke(page: Int): PaginatedListDomainModel<TvShowDomainModel> =
        repository.getTopRatedShows(page)
}
