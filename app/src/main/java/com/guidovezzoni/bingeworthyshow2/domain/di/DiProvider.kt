package com.guidovezzoni.bingeworthyshow2.domain.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.guidovezzoni.bingeworthyshow2.data.di.DiProvider.mdbRepository
import com.guidovezzoni.bingeworthyshow2.domain.usecase.GetConfigurationUseCase
import com.guidovezzoni.bingeworthyshow2.domain.usecase.GetTopRatedShowsUseCase
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.viewmodel.TvShowListViewModel
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.viewmodel.ViewModelFactory

object DiProvider {
    fun provideGetConfigurationUseCase() = GetConfigurationUseCase(mdbRepository)

    fun provideGetTopRatedShowsUseCase() = GetTopRatedShowsUseCase(mdbRepository)

    fun provideViewModelProvider(owner: ViewModelStoreOwner): TvShowListViewModel {
        val viewModelFactory = ViewModelFactory()
        return ViewModelProvider(owner, viewModelFactory)[TvShowListViewModel::class.java]
    }
}
