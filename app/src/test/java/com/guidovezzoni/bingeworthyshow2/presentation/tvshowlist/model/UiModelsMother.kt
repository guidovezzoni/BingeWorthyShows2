package com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model

@Suppress("MemberVisibilityCanBePrivate")
object UiModelsMother {
    val TV_SHOW_UI_MODEL_1 = TvShowUiModel(0, "Lucifer", "https://base.urlw78034tbjhb", 10.0)
    val TV_SHOW_UI_MODEL_2 = TvShowUiModel(1, "Lupin", "https://base.urlw780ete54fds", 10.0)

    val TV_SHOW_UI_MODEL_PAGINATED_LIST = PaginatedListUiModel(
        items = listOf(TV_SHOW_UI_MODEL_1, TV_SHOW_UI_MODEL_2),
        page = 1,
        totalItems = 2,
        totalPages = 1,
    )
}
