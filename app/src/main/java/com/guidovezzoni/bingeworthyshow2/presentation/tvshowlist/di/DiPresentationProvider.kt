package com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.viewmodel.TvShowListViewModel
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.viewmodel.ViewModelFactory

object DiPresentationProvider {
    fun provideViewModelProvider(owner: ViewModelStoreOwner): TvShowListViewModel {
        val viewModelFactory = ViewModelFactory()
        return ViewModelProvider(owner, viewModelFactory)[TvShowListViewModel::class.java]
    }
}
