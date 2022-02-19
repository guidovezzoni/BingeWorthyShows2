package com.guidovezzoni.bingeworthyshow2.data.repository

import com.guidovezzoni.bingeworthyshow2.data.datasource.MdbRestDatasource
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

class MdbRepositoryImplTest {

    @RelaxedMockK
    private lateinit var mdbRestDatasource: MdbRestDatasource

    private lateinit var sut: MdbRepositoryImpl

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        Dispatchers.setMain(Dispatchers.Unconfined)

        sut = MdbRepositoryImpl(mdbRestDatasource)
    }

    @AfterEach
    fun tearDown() = Dispatchers.resetMain()

    @Test
    fun `getTopRatedShows invokes api method`() =
        runBlockingTest {
            sut.getTopRatedShows(6)

            coVerify { mdbRestDatasource.getTopRatedShows(6) }
        }

    @Test
    fun `getConfiguration invokes api method the first time`() =
        runBlockingTest {
            sut.getConfiguration()

            coVerify { mdbRestDatasource.getConfiguration() }
        }

    @Test
    fun `getConfiguration invokes api method only once`() =
        runBlockingTest {
            sut.getConfiguration()
            sut.getConfiguration()
            sut.getConfiguration()

            coVerify(exactly = 1) { mdbRestDatasource.getConfiguration() }
        }
}
