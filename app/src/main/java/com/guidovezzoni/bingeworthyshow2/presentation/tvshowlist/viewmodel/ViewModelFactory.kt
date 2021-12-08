package com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.guidovezzoni.bingeworthyshow2.data.api.MdbApi
import com.guidovezzoni.bingeworthyshow2.domain.di.DiProvider

class ViewModelFactory(private val mdbApi: MdbApi) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TvShowListViewModel::class.java)) {
            return TvShowListViewModel(
                DiProvider.provideGetConfigurationUseCase(),
                DiProvider.provideGetTopRatedShowsUseCase(),
            ) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}
