package com.guidovezzoni.bingeworthyshow2.data.datasource

import com.guidovezzoni.bingeworthyshow2.data.api.MdbApi
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MdbRestDatasourceTest {

    @RelaxedMockK
    private lateinit var api: MdbApi

    private lateinit var sut: MdbRestDatasource

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        Dispatchers.setMain(Dispatchers.Unconfined)

        sut = MdbRestDatasource(api, API_KEY)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getConfiguration invokes api method`() =
        runBlockingTest {
            sut.getConfiguration()

            coVerify { api.getConfiguration(API_KEY) }
        }

    @Test
    fun `getTopRatedShows invokes api method`() =
        runBlockingTest {
            sut.getTopRatedShows(6)

            coVerify { api.getTopRatedShows(API_KEY, 6) }
        }

    companion object {
        private const val API_KEY = "a key"
    }
}
