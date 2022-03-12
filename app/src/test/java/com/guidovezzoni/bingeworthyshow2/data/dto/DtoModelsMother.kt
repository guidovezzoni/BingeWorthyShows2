package com.guidovezzoni.bingeworthyshow2.data.dto

@Suppress("MemberVisibilityCanBePrivate")
internal object DtoModelsMother {
    val ANY_IMAGES_DTO = ImagesDto(
        baseUrl = "http://base.url",
        secureBaseUrl = "https://base.url",
        backdropSizes = listOf("w92", "w154", "w185", "w342", "w500", "w780", "original"),
        logoSizes = listOf("w92", "w154", "w185", "w342", "w500", "w780", "original"),
        posterSizes = listOf("w92", "w154", "w185", "w342", "w500", "w780", "original"),
        profileSizes = listOf("w92", "w154", "w185", "w342", "w500", "w780", "original"),
        stillSizes = listOf("w92", "w154", "w185", "w342", "w500", "w780", "original"),
    )

    val ANY_CONFIGURATION_DTO = ConfigurationResponseDto(
        images = ANY_IMAGES_DTO,
        changeKeys = listOf("something", "some other thing")
    )

    val TV_SHOW_DTO_MODEL_1 = TvShowDto(
        posterPath = "34tbjhb",
        popularity = 0.0,
        id = 7675,
        backdropPath = "",
        voteAverage = 9.7,
        overview = "",
        firstAirDate = "",
        originCountry = listOf(""),
        genreIds = listOf(2),
        originalLanguage = "",
        voteCount = 0,
        name = "Lucifer",
        originalName = "",
    )

    val TV_SHOW_DTO_MODEL_2 = TvShowDto(
        posterPath = "ete54fds",
        popularity = 0.0,
        id = 75745,
        backdropPath = "",
        voteAverage = 7.4,
        overview = "",
        firstAirDate = "",
        originCountry = listOf(""),
        genreIds = listOf(2),
        originalLanguage = "",
        voteCount = 0,
        name = "Lupin",
        originalName = "",
    )

    val ANY_PAGINATED_RESPONSE_DTO = PaginatedResponseDto(
        page = 1,
        results = listOf(TV_SHOW_DTO_MODEL_1, TV_SHOW_DTO_MODEL_2),
        totalResults = 2,
        totalPages = 1,
    )
}
