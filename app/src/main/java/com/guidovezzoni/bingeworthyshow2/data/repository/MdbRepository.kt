package com.guidovezzoni.bingeworthyshow2.data.repository

import com.guidovezzoni.bingeworthyshow2.data.dto.ConfigurationResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.PaginatedResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.TvShowDto
import io.reactivex.rxjava3.core.Observable

interface MdbRepository {

    fun getConfiguration(): Observable<ConfigurationResponseDto>

    fun getTopRatedShows(page: Int): Observable<PaginatedResponseDto<TvShowDto>>

}
