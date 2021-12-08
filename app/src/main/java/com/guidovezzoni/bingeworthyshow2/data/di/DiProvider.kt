package com.guidovezzoni.bingeworthyshow2.data.di

import com.guidovezzoni.bingeworthyshow2.BuildConfig.THE_MOVIE_DB_KEY
import com.guidovezzoni.bingeworthyshow2.data.api.MdbApi
import com.guidovezzoni.bingeworthyshow2.data.datasource.MdbRestDatasource
import com.guidovezzoni.bingeworthyshow2.data.repository.MdbRepository
import com.guidovezzoni.bingeworthyshow2.data.repository.MdbRepositoryImpl
import com.guidovezzoni.bingeworthyshow2.utils.networking.RetrofitBuilder

object DiProvider {
    val mdbApi: MdbApi by lazy { RetrofitBuilder.MDB_API }

    val mdbRepository: MdbRepository by lazy {
        val datasource = MdbRestDatasource(mdbApi, THE_MOVIE_DB_KEY)
        MdbRepositoryImpl(datasource)
    }
}
