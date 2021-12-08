package com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.guidovezzoni.bingeworthyshow2.databinding.ActivityTvShowListBinding
import com.guidovezzoni.bingeworthyshow2.domain.di.DiManager
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.adapter.OnPaginatedScrollListener
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.adapter.TvShowAdapter
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.viewmodel.TvShowListViewModel
import com.guidovezzoni.bingeworthyshow2.utils.extension.showToast

class TvShowListActivity : AppCompatActivity() {
    private lateinit var tvShowListViewModel: TvShowListViewModel
    private lateinit var binding: ActivityTvShowListBinding

    private lateinit var adapter: TvShowAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTvShowListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupSwipeToRefresh()
        setupRecyclerView()
    }

    private fun setupViewModel() {
        tvShowListViewModel = DiManager.provideViewModelProvider(this)
        tvShowListViewModel.getTopRatedShows().observe(this) {
            it?.let { result ->
                result.fold(
                    { listUiModel -> adapter.addItems(listUiModel.items) },
                    { showToast("Error retrieving tv shows") }
                )
            }
        }
    }

    private fun setupSwipeToRefresh() {
        // TODO complete
        binding.swipeToRefresh.setOnRefreshListener { }
    }

    private fun setupRecyclerView() {
        val recyclerView = binding.list
        adapter = TvShowAdapter()
        recyclerView.adapter = adapter
        recyclerView.addOnScrollListener(
            OnPaginatedScrollListener(recyclerView) { tvShowListViewModel.getMoreData() }
        )
    }
}
