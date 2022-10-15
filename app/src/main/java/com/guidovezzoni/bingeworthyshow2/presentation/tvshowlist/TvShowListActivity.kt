package com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.material.composethemeadapter.MdcTheme
import com.guidovezzoni.bingeworthyshow2.R
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTvShowListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupSwipeToRefresh()
        setupRecyclerView()
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
        recyclerView.addOnScrollListener(
            OnPaginatedScrollListener(recyclerView) { tvShowListViewModel.getMoreData() }
        )
    }

    companion object {
        private const val FIRST_PAGE = 1L
    }
}

@Composable
fun itemInfo(
    model: TvShowUiModel,
    modifier: Modifier = Modifier,
) {
    Surface(
        color = colorResource(id = R.color.item_tvshow_overlay_background).copy(alpha = 0.5f),
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(
                maxLines = 3,
                style = MaterialTheme.typography.h6,
                overflow = TextOverflow.Ellipsis,
                text = model.name
            )
            Row(modifier = Modifier.padding(top = 8.dp)) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "stars",
                    tint = Color.Yellow,
                )
                Text(
                    text = model.voteAverage.toString()
                        ?: "",  // this should happen when populating UIModel
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview(widthDp = 250)
//@Preview(widthDp = 250, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun itemInfoPreview() {
    MdcTheme {
        itemInfo(
            TvShowUiModel(
                id = 0,
                name = "The Mandalorian - very long description for ths field blah blah blah \nblah",
                posterUrl = "",
                voteAverage = 9.9387,
            )
        )
    }
}

@Composable
fun fullItem(
    model: TvShowUiModel,
    modifier: Modifier = Modifier,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        itemInfo(
            model = model,
            modifier = Modifier.align(Alignment.BottomCenter),
        )
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
//                .fillMaxWidth()
//                .aspectRatio(2f / 3f)
        )
    }
}

@Preview(widthDp = 250)
//@Preview(widthDp = 250, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun fullItemPreview() {
    MdcTheme {
        val model = TvShowUiModel(
            id = 0,
            name = "The Mandalorian - very long description for ths field blah blah blah \nblah",
            posterUrl = "",
            voteAverage = 9.9387,
        )
        fullItem(model)
    }
}
