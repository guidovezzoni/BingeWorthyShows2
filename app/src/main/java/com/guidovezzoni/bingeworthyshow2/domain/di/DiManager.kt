package com.guidovezzoni.bingeworthyshow2.domain.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.guidovezzoni.bingeworthyshow2.BuildConfig
import com.guidovezzoni.bingeworthyshow2.data.api.MdbApi
import com.guidovezzoni.bingeworthyshow2.data.datasource.MdbRestDatasource
import com.guidovezzoni.bingeworthyshow2.data.repository.MdbRepository
import com.guidovezzoni.bingeworthyshow2.data.repository.MdbRepositoryImpl
import com.guidovezzoni.bingeworthyshow2.domain.usecase.GetConfigurationUseCase
import com.guidovezzoni.bingeworthyshow2.domain.usecase.GetTopRatedShowsUseCase
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.viewmodel.TvShowListViewModel
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.viewmodel.ViewModelFactory
import com.guidovezzoni.bingeworthyshow2.utils.networking.RetrofitBuilder

object DiManager {

    private val mdbApi: MdbApi by lazy { RetrofitBuilder.MDB_API }

    private val mdbRepository: MdbRepository by lazy {
        val datasource = MdbRestDatasource(mdbApi, BuildConfig.THE_MOVIE_DB_KEY)
        MdbRepositoryImpl(datasource)
    }

    fun provideGetConfigurationUseCase() = GetConfigurationUseCase(mdbRepository)

    fun provideGetTopRatedShowsUseCase() = GetTopRatedShowsUseCase(mdbRepository)

    fun provideViewModelProvider(owner: ViewModelStoreOwner): TvShowListViewModel {
        val viewModelFactory = ViewModelFactory(mdbApi)
        return ViewModelProvider(owner, viewModelFactory)[TvShowListViewModel::class.java]
    }
}
