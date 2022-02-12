package com.guidovezzoni.bingeworthyshow2.data.datasource

import com.guidovezzoni.bingeworthyshow2.data.api.MdbApi

class MdbRestDatasource(private val api: MdbApi, private val apiKey: String) : MdbDatasource {

    override fun getConfiguration() = api.getConfiguration(apiKey)

    override fun getTopRatedShows(page: Int) = api.getTopRatedShows(apiKey, page)
}
