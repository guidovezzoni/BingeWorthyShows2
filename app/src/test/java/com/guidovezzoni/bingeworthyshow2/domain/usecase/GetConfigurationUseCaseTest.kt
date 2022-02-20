package com.guidovezzoni.bingeworthyshow2.domain.usecase

import com.guidovezzoni.bingeworthyshow2.data.repository.MdbRepository
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

class GetConfigurationUseCaseTest {

    @RelaxedMockK
    private lateinit var mdbRepository: MdbRepository

    private lateinit var sut: GetConfigurationUseCase

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        Dispatchers.setMain(Dispatchers.Unconfined)

        sut = GetConfigurationUseCase(mdbRepository)
    }

    @AfterEach
    fun tearDown() = Dispatchers.resetMain()

    @Test
    fun `getTopRatedShows invokes api method`() =
        runBlockingTest {
            sut()

            coVerify { mdbRepository.getConfiguration() }
        }
}
