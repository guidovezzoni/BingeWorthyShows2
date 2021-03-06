package com.guidovezzoni.bingeworthyshow2.domain.model

@Suppress("MemberVisibilityCanBePrivate")
object DomainModelsMother {
    val ANY_CONFIGURATION_DOMAIN_MODEL = ConfigurationDomainModel(
        imageBaseUrl = "https://base.url",
        posterSizes = listOf("w92", "w154", "w185", "w342", "w500", "w780", "original")
    )

    val LOWER_RES_CONFIGURATION_DOMAIN_MODEL = ConfigurationDomainModel(
        imageBaseUrl = "https://base.url",
        posterSizes = listOf("w92", "w154", "w185", "w342", "original")
    )

    val ORIGINAL_CONFIGURATION_DOMAIN_MODEL = ConfigurationDomainModel(
        imageBaseUrl = "https://base.url",
        posterSizes = listOf("original")
    )

    val TV_SHOW_DOMAIN_MODEL_1 = TvShowDomainModel(7675, "Lucifer", "34tbjhb", 9.7)
    val TV_SHOW_DOMAIN_MODEL_2 = TvShowDomainModel(75745, "Lupin", "ete54fds", 7.4)

    val A_TV_SHOW_PAGINATED_LIST = PaginatedListDomainModel(
        items = listOf(TV_SHOW_DOMAIN_MODEL_1, TV_SHOW_DOMAIN_MODEL_2),
        page = 1,
        totalItems = 2,
        totalPages = 1,
    )
}
