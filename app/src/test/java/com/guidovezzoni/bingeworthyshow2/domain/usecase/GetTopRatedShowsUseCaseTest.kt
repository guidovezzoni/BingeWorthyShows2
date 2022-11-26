package com.guidovezzoni.bingeworthyshow2.domain.usecase

import com.guidovezzoni.bingeworthyshow2.domain.repository.MdbRepository
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

class GetTopRatedShowsUseCaseTest {

    @RelaxedMockK
    private lateinit var mdbRepository: MdbRepository

    private lateinit var sut: GetTopRatedShowsUseCase

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        Dispatchers.setMain(Dispatchers.Unconfined)

        sut = GetTopRatedShowsUseCase(mdbRepository)
    }

    @AfterEach
    fun tearDown() = Dispatchers.resetMain()

    @Test
    fun `getTopRatedShows invokes api method`() =
        runBlockingTest {
            sut(8)

            coVerify { mdbRepository.getTopRatedShows(8) }
        }
}
