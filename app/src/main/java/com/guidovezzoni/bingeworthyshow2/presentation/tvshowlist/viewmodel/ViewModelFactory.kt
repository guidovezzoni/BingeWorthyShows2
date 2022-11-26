package com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.guidovezzoni.bingeworthyshow2.data.di.DiDataProvider
import com.guidovezzoni.bingeworthyshow2.domain.di.DiDomainProvider

class ViewModelFactory() :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TvShowListViewModel::class.java)) {
            return TvShowListViewModel(
                DiDomainProvider.provideGetConfigurationUseCase(DiDataProvider.mdbRepository),
                DiDomainProvider.provideGetTopRatedShowsUseCase(DiDataProvider.mdbRepository),
            ) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}
