package com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.viewmodel

import androidx.lifecycle.ViewModel
import com.guidovezzoni.bingeworthyshow2.domain.usecase.GetConfigurationUseCase
import com.guidovezzoni.bingeworthyshow2.domain.usecase.GetTopRatedShowsUseCase
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model.PaginatedListUiModel
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model.TvShowUiModel
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model.toPaginatedTvShowList
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.processors.PublishProcessor

class TvShowListViewModel(
    private val getConfigurationUseCase: GetConfigurationUseCase,
    private val getTopRatedShowsUseCase: GetTopRatedShowsUseCase,
) : ViewModel() {

    private var lastRequestedPage: Int = 0

    private val trigger: PublishProcessor<Boolean> = PublishProcessor.create()

    fun refreshData() = trigger.onNext(true)

    fun getMoreData() = trigger.onNext(false)

    fun getTopRatedShows(): Observable<PaginatedListUiModel<TvShowUiModel>> {
        return trigger
            .toObservable()
            .flatMap { getShowsPage(it) }
    }

    private fun getShowsPage(forceReload: Boolean): Observable<PaginatedListUiModel<TvShowUiModel>> {
        if (forceReload) lastRequestedPage = 0

        return getTopRatedShowsUseCase(page = lastRequestedPage + 1)
            .flatMap { list ->
                getConfigurationUseCase()
                    .map { configuration -> list.toPaginatedTvShowList(configuration) }
            }
            .doOnNext { lastRequestedPage++ }
    }
}
