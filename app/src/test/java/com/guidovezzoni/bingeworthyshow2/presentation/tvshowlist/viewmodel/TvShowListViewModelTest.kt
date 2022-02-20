package com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.viewmodel

import com.guidovezzoni.bingeworthyshow2.domain.model.DomainModelsMother.ANY_CONFIGURATION_DOMAIN_MODEL
import com.guidovezzoni.bingeworthyshow2.domain.model.DomainModelsMother.A_TV_SHOW_PAGINATED_LIST
import com.guidovezzoni.bingeworthyshow2.domain.usecase.GetConfigurationUseCase
import com.guidovezzoni.bingeworthyshow2.domain.usecase.GetTopRatedShowsUseCase
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model.UiModelsMother.TV_SHOW_UI_MODEL_PAGINATED_LIST
import com.guidovezzoni.bingeworthyshow2.testutils.InstantExecutorExtension
import com.guidovezzoni.bingeworthyshow2.testutils.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantExecutorExtension::class)
class TvShowListViewModelTest {

    @RelaxedMockK
    private lateinit var getConfigurationUseCase: GetConfigurationUseCase

    @RelaxedMockK
    private lateinit var getTopRatedShowsUseCase: GetTopRatedShowsUseCase

    private lateinit var sut: TvShowListViewModel

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        Dispatchers.setMain(Dispatchers.Unconfined)

        sut = TvShowListViewModel(
            getConfigurationUseCase,
            getTopRatedShowsUseCase,
            Dispatchers.Unconfined
        )
    }

    @AfterEach
    fun tearDown() = Dispatchers.resetMain()

    @Test
    fun `when load initial page gets correct result`() = runBlockingTest {
        //Arrange
        coEvery { getTopRatedShowsUseCase(1) }.returns(A_TV_SHOW_PAGINATED_LIST)
        coEvery { getConfigurationUseCase() }.returns(ANY_CONFIGURATION_DOMAIN_MODEL)

        //Act
        val orAwaitValue = sut.getTopRatedShows().getOrAwaitValue()

        //Assert
        assertEquals(true, orAwaitValue.isSuccess)
        assertEquals(TV_SHOW_UI_MODEL_PAGINATED_LIST, orAwaitValue.getOrNull())
    }
}
