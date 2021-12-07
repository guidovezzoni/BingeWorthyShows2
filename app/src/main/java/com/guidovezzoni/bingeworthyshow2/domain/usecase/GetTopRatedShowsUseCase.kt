package com.guidovezzoni.bingeworthyshow2.domain.usecase

import com.guidovezzoni.bingeworthyshow2.data.repository.MdbRepository

class GetTopRatedShowsUseCase(private val repository: MdbRepository) {

    suspend operator fun invoke() = repository.getTopRatedShows()

}
