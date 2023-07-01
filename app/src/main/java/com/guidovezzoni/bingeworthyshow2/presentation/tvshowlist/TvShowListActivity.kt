package com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.guidovezzoni.bingeworthyshow2.databinding.ActivityTvShowListBinding
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.adapter.OnPaginatedScrollListener
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.adapter.TvShowAdapter
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.di.DiPresentationProvider.provideViewModelProvider
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model.PaginatedListUiModel
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model.TvShowUiModel
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.viewmodel.TvShowListViewModel
import com.guidovezzoni.bingeworthyshow2.utils.extension.showToast
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers

class TvShowListActivity : AppCompatActivity() {
    private lateinit var tvShowListViewModel: TvShowListViewModel
    private lateinit var binding: ActivityTvShowListBinding

    private lateinit var adapter: TvShowAdapter

    private var compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTvShowListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupSwipeToRefresh()
        setupRecyclerView()
    }

    private fun setupViewModel() {
        tvShowListViewModel = provideViewModelProvider(this)

        compositeDisposable.add(
            tvShowListViewModel.getTopRatedShows()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onError = {
                        Log.e(TAG, "Error retrieving tv shows", it)
                        showToast("Error retrieving tv shows")
                    },
                    onNext = { listUiModel -> onSuccessfulRequest(listUiModel) }
                )
        )
    }

    private fun onSuccessfulRequest(listUiModel: PaginatedListUiModel<TvShowUiModel>) {
        adapter.addItems(
            newItems = listUiModel.items,
            clearBeforeAdding = listUiModel.page == FIRST_PAGE,
        )
        binding.swipeToRefresh.isRefreshing = false
    }

    private fun setupSwipeToRefresh() =
        binding.swipeToRefresh.setOnRefreshListener { tvShowListViewModel.refreshData() }

    private fun setupRecyclerView() {
        val recyclerView = binding.list

        adapter = TvShowAdapter()
        recyclerView.adapter = adapter
        recyclerView.addOnScrollListener(
            OnPaginatedScrollListener(recyclerView) { tvShowListViewModel.getMoreData() }
        )
    }

    override fun onStart() {
        super.onStart()
        tvShowListViewModel.refreshData()
    }

    override fun onStop() {
        compositeDisposable.clear()
        super.onStop()
    }

    companion object {
        private const val FIRST_PAGE = 1L
        private const val TAG = "TvShowListActivity"
    }
}
