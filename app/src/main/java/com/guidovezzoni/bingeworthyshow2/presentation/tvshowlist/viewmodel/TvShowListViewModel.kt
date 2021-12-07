package com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.guidovezzoni.bingeworthyshow2.domain.GetTopRatedShowsUseCase
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model.PaginatedListUiModel
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model.TvShowUiModel
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model.toPaginatedTvShowList
import kotlinx.coroutines.Dispatchers

class TvShowListViewModel(
    private val getTopRatedShowsUseCase: GetTopRatedShowsUseCase,
) : ViewModel() {

    fun getTopRatedShows(): LiveData<Result<PaginatedListUiModel<TvShowUiModel>>> =
        liveData(Dispatchers.IO) {
            try {
                emit(Result.success(value = getTopRatedShowsUseCase().toPaginatedTvShowList()))
            } catch (exception: Exception) {
                emit(Result.failure(exception = exception))
            }
        }
}
