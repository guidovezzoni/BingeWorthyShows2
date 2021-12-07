package com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.adapter

import androidx.recyclerview.widget.RecyclerView
import com.guidovezzoni.bingeworthyshow2.databinding.ItemTvShowBinding
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model.TvShowUiModel
import java.util.*

class TvShowViewHolder(private val binding: ItemTvShowBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(tvShow: TvShowUiModel) {
        with(binding) {
            // TODO load bitmap
            showTitle.text = tvShow.name
            showAverageVote.text = getRating(tvShow)
        }
    }

    private fun getRating(tvShow: TvShowUiModel): String =
        tvShow.voteAverage?.let { String.format(Locale.getDefault(), AVERAGE_VOTE_FORMAT, it) }
            ?: AVERAGE_VOTE_MISSING

    companion object {
        private const val AVERAGE_VOTE_FORMAT = "%.01f"
        private const val AVERAGE_VOTE_MISSING = "-"
    }
}
