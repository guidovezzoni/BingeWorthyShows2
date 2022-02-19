package com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model

import com.guidovezzoni.bingeworthyshow2.domain.model.PaginatedListDomainModel

@Suppress("MemberVisibilityCanBePrivate")
object UiModelsMother {
    val TV_SHOW_UI_MODEL_1 = TvShowUiModel(0, "Lucifer", "34tbjhb", 10.0)
    val TV_SHOW_UI_MODEL_2 = TvShowUiModel(1, "Lupin", "ete54fds", 10.0)

    val TV_SHOW_UI_MODEL_PAGINATED_LIST = PaginatedListDomainModel(
        items = listOf(TV_SHOW_UI_MODEL_1, TV_SHOW_UI_MODEL_2),
        page = 1,
        totalItems = 2,
        totalPages = 1,
    )
}
