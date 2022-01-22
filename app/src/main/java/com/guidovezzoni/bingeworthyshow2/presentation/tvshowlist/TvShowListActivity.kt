package com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist

import android.net.*
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.guidovezzoni.bingeworthyshow2.databinding.ActivityTvShowListBinding
import com.guidovezzoni.bingeworthyshow2.domain.di.DiProvider
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.adapter.OnPaginatedScrollListener
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.adapter.TvShowAdapter
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model.PaginatedListUiModel
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model.TvShowUiModel
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.viewmodel.TvShowListViewModel
import com.guidovezzoni.bingeworthyshow2.utils.extension.showToast


class TvShowListActivity : AppCompatActivity() {
    private lateinit var tvShowListViewModel: TvShowListViewModel
    private lateinit var binding: ActivityTvShowListBinding

    private lateinit var adapter: TvShowAdapter
    private var onPaginatedScrollListener: OnPaginatedScrollListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTvShowListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupSwipeToRefresh()
        setupRecyclerView()
        setupConnectionManager()
    }

    private fun setupConnectionManager() {
        val cm = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

        val request = NetworkRequest.Builder()
        request.addTransportType(NetworkCapabilities.TRANSPORT_WIFI)

        cm.requestNetwork(request.build(), object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                onPaginatedScrollListener?.resetLoading()
            }

            override fun onLosing(network: Network, maxMsToLive: Int) {
            }

            override fun onLost(network: Network) {
            }

            override fun onUnavailable() {
            }

            override fun onCapabilitiesChanged(
                network: Network,
                networkCapabilities: NetworkCapabilities
            ) {
            }

            override fun onLinkPropertiesChanged(network: Network, linkProperties: LinkProperties) {
            }

            override fun onBlockedStatusChanged(network: Network, blocked: Boolean) {
            }
        })
    }

    private fun setupViewModel() {
        tvShowListViewModel = DiProvider.provideViewModelProvider(this)
        tvShowListViewModel.getTopRatedShows().observe(this) {
            it?.let { result ->
                result.fold(
                    { listUiModel -> onSuccessfulRequest(listUiModel) },
                    { showToast("Error retrieving tv shows") }
                )
            }
        }
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
        onPaginatedScrollListener =
            OnPaginatedScrollListener(recyclerView) { tvShowListViewModel.getMoreData() }
                .also { recyclerView.addOnScrollListener(it) }
    }

    companion object {
        private const val FIRST_PAGE = 1L
    }
}
