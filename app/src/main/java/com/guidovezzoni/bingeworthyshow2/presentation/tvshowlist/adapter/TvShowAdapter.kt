package com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guidovezzoni.bingeworthyshow2.databinding.ItemTvShowBinding
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model.TvShowUiModel

class TvShowAdapter : RecyclerView.Adapter<TvShowViewHolder>() {
    private var internalList: MutableList<TvShowUiModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val binding = ItemTvShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) =
        holder.bind(internalList[position])

    override fun getItemCount(): Int = internalList.size

    fun clearItems() {
        internalList.clear()
        notifyDataSetChanged()
    }

    fun addItems(newItems: List<TvShowUiModel>) {
        internalList.addAll(newItems)
        notifyDataSetChanged()
    }
}
