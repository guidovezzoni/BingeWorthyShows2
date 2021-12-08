package com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.adapter

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver

open class OnPaginatedScrollListener(
    recyclerView: RecyclerView,
    private val onReachingBottomAction: () -> Unit,
) : RecyclerView.OnScrollListener() {

    private var loading = false

    init {
        val adapter = recyclerView.adapter
            ?: throw NullPointerException("Adapter needs to be not null")

        adapter.registerAdapterDataObserver(object : AdapterDataObserver() {
            override fun onChanged() {
                super.onChanged()
                loading = false
            }
        })
    }

    private val layoutManager: LinearLayoutManager =
        recyclerView.layoutManager as LinearLayoutManager

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val totalItemCount = layoutManager.itemCount
        val lastVisibleItem = layoutManager.findLastVisibleItemPosition()

        if (!loading && totalItemCount <= lastVisibleItem + VISIBLE_THRESHOLD) {
            onReachingBottomAction()
            loading = true
        }
    }

    companion object {
        private const val VISIBLE_THRESHOLD = 10
    }
}
