package com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.viewmodel

import androidx.lifecycle.*
import com.guidovezzoni.bingeworthyshow2.domain.usecase.GetConfigurationUseCase
import com.guidovezzoni.bingeworthyshow2.domain.usecase.GetTopRatedShowsUseCase
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model.PaginatedListUiModel
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model.TvShowUiModel
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model.toPaginatedTvShowList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class TvShowListViewModel(
    private val getConfigurationUseCase: GetConfigurationUseCase,
    private val getTopRatedShowsUseCase: GetTopRatedShowsUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ViewModel() {

    private var lastRequestedPage: Int = 0

    private val loadTvShowTrigger = MutableLiveData(true)

    fun refreshData() {
        loadTvShowTrigger.value = true
    }

    fun getMoreData() {
        loadTvShowTrigger.value = false
    }

    fun getTopRatedShows(): LiveData<Result<PaginatedListUiModel<TvShowUiModel>>> =
        loadTvShowTrigger.switchMap { reloadList -> loadTopRatedShows(reloadList) }

    private fun loadTopRatedShows(forceReload: Boolean = false):
            LiveData<Result<PaginatedListUiModel<TvShowUiModel>>> =
        liveData(dispatcher) {
            try {
                if (forceReload) lastRequestedPage = 0

                val tmdbConfiguration = getConfigurationUseCase()
                val valueToBeEmitted =
                    Result.success(
                        getTopRatedShowsUseCase(lastRequestedPage + 1)
                            .toPaginatedTvShowList(tmdbConfiguration)
                    )
                // increment only after successful completion of the above network call: in case of
                // loading errors the user can retry to reload the missing page - by swiping up and
                // down again
                lastRequestedPage++
                emit(valueToBeEmitted)
            } catch (exception: Exception) {
                emit(Result.failure(exception = exception))
            }
        }
}
