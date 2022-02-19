package com.guidovezzoni.bingeworthyshow2.data.datasource

import com.guidovezzoni.bingeworthyshow2.data.api.MdbApi
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MdbRestDatasourceTest {

    @RelaxedMockK
    private lateinit var api: MdbApi

    private lateinit var sut: MdbRestDatasource

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)

        sut = MdbRestDatasource(api, API_KEY)
    }

    @Test
    fun `getConfiguration invokes api method`() {
        sut.getConfiguration()

        verify { api.getConfiguration(API_KEY) }
    }

    @Test
    fun `getTopRatedShows invokes api method`() {
        sut.getTopRatedShows(6)

        verify { api.getTopRatedShows(API_KEY, 6) }
    }

    companion object {
        private const val API_KEY = "a key"
    }
}
