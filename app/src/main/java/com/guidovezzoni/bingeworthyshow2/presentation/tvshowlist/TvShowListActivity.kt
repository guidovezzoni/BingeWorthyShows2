package com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.guidovezzoni.bingeworthyshow2.R
import com.guidovezzoni.bingeworthyshow2.domain.di.DiManager
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.viewmodel.TvShowListViewModel
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.viewmodel.ViewModelFactory
import com.guidovezzoni.bingeworthyshow2.utils.RetrofitBuilder

class TvShowListActivity : AppCompatActivity() {
    private lateinit var tvShowListViewModel: TvShowListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tv_show_list_activity)

        tvShowListViewModel = DiManager.provideViewModelProvider(this)

        tvShowListViewModel.getTopRatedShows().observe(this) {
            it?.let { result ->
                result.fold({
                    // update UI with it
                }, {
                    // toast
                })
            }
        }
    }
}
