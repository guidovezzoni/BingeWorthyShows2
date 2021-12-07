package com.guidovezzoni.bingeworthyshow2.domain.di

import com.guidovezzoni.bingeworthyshow2.data.api.MdbApi
import com.guidovezzoni.bingeworthyshow2.data.repository.MdbRepositoryImpl
import com.guidovezzoni.bingeworthyshow2.domain.GetTopRatedShowsUseCase

object Provider {
    fun provideGetTopRatedShowsUseCase(api: MdbApi) =
        GetTopRatedShowsUseCase(MdbRepositoryImpl(api))
}
