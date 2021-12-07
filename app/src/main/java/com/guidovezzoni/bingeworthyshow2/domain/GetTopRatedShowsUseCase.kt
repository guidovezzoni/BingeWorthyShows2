package com.guidovezzoni.bingeworthyshow2.domain

import com.guidovezzoni.bingeworthyshow2.data.MdbRepository

class GetTopRatedShowsUseCase(private val repository: MdbRepository) {

    suspend operator fun invoke() = repository.getTopRatedShows()

}
