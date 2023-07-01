package com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.viewmodel

import com.guidovezzoni.bingeworthyshow2.domain.model.DomainModelsMother.ANY_CONFIGURATION_DOMAIN_MODEL
import com.guidovezzoni.bingeworthyshow2.domain.model.DomainModelsMother.A_TV_SHOW_PAGINATED_LIST
import com.guidovezzoni.bingeworthyshow2.domain.usecase.GetConfigurationUseCase
import com.guidovezzoni.bingeworthyshow2.domain.usecase.GetTopRatedShowsUseCase
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model.PaginatedListUiModel
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model.TvShowUiModel
import com.guidovezzoni.bingeworthyshow2.presentation.tvshowlist.model.UiModelsMother.TV_SHOW_UI_MODEL_PAGINATED_LIST
import com.guidovezzoni.bingeworthyshow2.testutils.InstantExecutorExtension
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.TestObserver
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

        sut = TvShowListViewModel(
            getConfigurationUseCase,
            getTopRatedShowsUseCase
        )
    }

    @Test
    fun `when load initial page gets correct result`() {
        //Arrange
        val testObserver = TestObserver<PaginatedListUiModel<TvShowUiModel>>()
        every { getConfigurationUseCase() }
            .returns(Observable.just(ANY_CONFIGURATION_DOMAIN_MODEL))
        every { getTopRatedShowsUseCase(1) }
            .returns(Observable.just(A_TV_SHOW_PAGINATED_LIST))

        //Act
        sut.getTopRatedShows()
            .subscribe(testObserver)

        sut.refreshData()

        //Assert
        testObserver
            .assertValue(TV_SHOW_UI_MODEL_PAGINATED_LIST)
            .assertNoErrors()
            .assertNotComplete()

        verify { getConfigurationUseCase() }
        verify { getTopRatedShowsUseCase(1) }
    }
}
