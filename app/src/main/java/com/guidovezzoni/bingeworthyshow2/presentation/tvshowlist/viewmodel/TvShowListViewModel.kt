package com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.guidovezzoni.bingeworthyshow2.domain.usecase.GetConfigurationUseCase
import com.guidovezzoni.bingeworthyshow2.domain.usecase.GetTopRatedShowsUseCase
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model.PaginatedListUiModel
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model.TvShowUiModel
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model.toPaginatedTvShowList
import kotlinx.coroutines.Dispatchers

class TvShowListViewModel(
    private val getConfigurationUseCase: GetConfigurationUseCase,
    private val getTopRatedShowsUseCase: GetTopRatedShowsUseCase,
) : ViewModel() {

    fun getTopRatedShows(): LiveData<Result<PaginatedListUiModel<TvShowUiModel>>> =
        liveData(Dispatchers.IO) {
            try {
                val config = getConfigurationUseCase()
                emit(
                    Result.success(value = getTopRatedShowsUseCase().toPaginatedTvShowList(config))
                )
            } catch (exception: Exception) {
                emit(Result.failure(exception = exception))
            }
        }
}
