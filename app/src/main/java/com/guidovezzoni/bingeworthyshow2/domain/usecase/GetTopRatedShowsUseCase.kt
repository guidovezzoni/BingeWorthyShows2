package com.guidovezzoni.bingeworthyshow2.domain.usecase

import com.guidovezzoni.bingeworthyshow2.data.dto.toPaginatedTvShowList
import com.guidovezzoni.bingeworthyshow2.domain.model.PaginatedListDomainModel
import com.guidovezzoni.bingeworthyshow2.domain.model.TvShowDomainModel
import com.guidovezzoni.bingeworthyshow2.domain.repository.MdbRepository
import io.reactivex.rxjava3.core.Observable

class GetTopRatedShowsUseCase(private val repository: MdbRepository) {

    operator fun invoke(page: Int): Observable<PaginatedListDomainModel<TvShowDomainModel>> =
        repository.getTopRatedShows(page)
            .map { it.toPaginatedTvShowList() }
}
