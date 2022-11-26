package com.guidovezzoni.bingeworthyshow2.domain.di

import com.guidovezzoni.bingeworthyshow2.domain.repository.MdbRepository
import com.guidovezzoni.bingeworthyshow2.domain.usecase.GetConfigurationUseCase
import com.guidovezzoni.bingeworthyshow2.domain.usecase.GetTopRatedShowsUseCase

object DiDomainProvider {
    fun provideGetConfigurationUseCase(repository: MdbRepository) =
        GetConfigurationUseCase(repository)

    fun provideGetTopRatedShowsUseCase(repository: MdbRepository) =
        GetTopRatedShowsUseCase(repository)
}
