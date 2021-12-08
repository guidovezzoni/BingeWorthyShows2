package com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.viewmodel

import androidx.lifecycle.*
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

    private var lastRequestedPage: Int = 0

    private val loadTrigger = MutableLiveData(Unit)

    fun refresh() {
        loadTrigger.value = Unit
    }

    fun getMoreData() {
        loadTrigger.value = Unit
    }

    fun getTopRatedShows(): LiveData<Result<PaginatedListUiModel<TvShowUiModel>>> =
        loadTrigger.switchMap { loadTopRatedShows() }

    private fun loadTopRatedShows(): LiveData<Result<PaginatedListUiModel<TvShowUiModel>>> =
        liveData(Dispatchers.IO) {
            try {
                val tmdbConfiguration = getConfigurationUseCase()
                val valueToBeEmitted =
                    Result.success(
                        getTopRatedShowsUseCase(lastRequestedPage + 1)
                            .toPaginatedTvShowList(tmdbConfiguration)
                    )
                // increment after successful completion of the network call
                lastRequestedPage++
                emit(valueToBeEmitted)
            } catch (exception: Exception) {
                emit(Result.failure(exception = exception))
            }
        }
}
