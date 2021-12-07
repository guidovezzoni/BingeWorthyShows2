package com.guidovezzoni.bingeworthyshow2.domain.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.guidovezzoni.bingeworthyshow2.BuildConfig
import com.guidovezzoni.bingeworthyshow2.data.api.MdbApi
import com.guidovezzoni.bingeworthyshow2.data.datasource.MdbRestDatasource
import com.guidovezzoni.bingeworthyshow2.data.repository.MdbRepositoryImpl
import com.guidovezzoni.bingeworthyshow2.domain.GetTopRatedShowsUseCase
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.viewmodel.TvShowListViewModel
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.viewmodel.ViewModelFactory
import com.guidovezzoni.bingeworthyshow2.utils.networking.RetrofitBuilder

object DiManager {
    fun provideGetTopRatedShowsUseCase(api: MdbApi): GetTopRatedShowsUseCase {
        val datasource = MdbRestDatasource(api, BuildConfig.THE_MOVIE_DB_KEY)
        val repository = MdbRepositoryImpl(datasource)
        return GetTopRatedShowsUseCase(repository)
    }

    fun provideViewModelProvider(owner: ViewModelStoreOwner): TvShowListViewModel {
        val viewModelFactory = ViewModelFactory(RetrofitBuilder.MDB_API)
        return ViewModelProvider(owner, viewModelFactory)[TvShowListViewModel::class.java]
    }
}
