package com.guidovezzoni.bingeworthyshow2.data.di

import com.guidovezzoni.bingeworthyshow2.BuildConfig.THE_MOVIE_DB_KEY
import com.guidovezzoni.bingeworthyshow2.data.api.MdbApiInstance.MDB_API
import com.guidovezzoni.bingeworthyshow2.data.datasource.MdbRestDatasource
import com.guidovezzoni.bingeworthyshow2.data.repository.MdbRepositoryImpl
import com.guidovezzoni.bingeworthyshow2.domain.repository.MdbRepository

object DiDataProvider {
    val mdbRepository: MdbRepository by lazy {
        val datasource = MdbRestDatasource(MDB_API, THE_MOVIE_DB_KEY)
        MdbRepositoryImpl(datasource)
    }
}
