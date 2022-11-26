package com.guidovezzoni.bingeworthyshow2.data.api

import com.guidovezzoni.bingeworthyshow2.utils.networking.RetrofitBuilder

object MdbApiInstance {
    private const val BASE_URL = "https://api.themoviedb.org"

    private fun getMdbApi(): MdbApi =
        RetrofitBuilder.getRetrofit(BASE_URL).create(MdbApi::class.java)

    val MDB_API: MdbApi = getMdbApi()
}
