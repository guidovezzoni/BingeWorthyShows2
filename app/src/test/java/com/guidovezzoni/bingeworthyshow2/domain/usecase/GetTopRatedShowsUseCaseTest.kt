package com.guidovezzoni.bingeworthyshow2.domain.usecase

import com.guidovezzoni.bingeworthyshow2.data.dto.DtoModelsMother.ANY_PAGINATED_RESPONSE_DTO
import com.guidovezzoni.bingeworthyshow2.data.repository.MdbRepository
import com.guidovezzoni.bingeworthyshow2.domain.model.DomainModelsMother.A_TV_SHOW_PAGINATED_LIST
import com.guidovezzoni.bingeworthyshow2.domain.model.PaginatedListDomainModel
import com.guidovezzoni.bingeworthyshow2.domain.model.TvShowDomainModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.TestObserver
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GetTopRatedShowsUseCaseTest {

    @RelaxedMockK
    private lateinit var mdbRepository: MdbRepository

    private lateinit var sut: GetTopRatedShowsUseCase

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)

        sut = GetTopRatedShowsUseCase(mdbRepository)
    }

    @Test
    fun `getTopRatedShows invokes api method`() {
        val testObserver = TestObserver<PaginatedListDomainModel<TvShowDomainModel>>()
        every { mdbRepository.getTopRatedShows(8) }
            .returns(Observable.just(ANY_PAGINATED_RESPONSE_DTO))

        sut(8).subscribe(testObserver)

        testObserver.assertResult(A_TV_SHOW_PAGINATED_LIST)
        verify { mdbRepository.getTopRatedShows(8) }
    }
}
