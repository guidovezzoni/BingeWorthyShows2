package com.guidovezzoni.bingeworthyshow2.data.repository

import com.guidovezzoni.bingeworthyshow2.data.datasource.MdbRestDatasource
import com.guidovezzoni.bingeworthyshow2.data.dto.ConfigurationResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.DtoModelsMother
import com.guidovezzoni.bingeworthyshow2.data.dto.DtoModelsMother.ANY_CONFIGURATION_DTO
import com.guidovezzoni.bingeworthyshow2.data.dto.DtoModelsMother.ANY_PAGINATED_RESPONSE_DTO
import com.guidovezzoni.bingeworthyshow2.data.dto.PaginatedResponseDto
import com.guidovezzoni.bingeworthyshow2.data.dto.TvShowDto
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.TestObserver
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MdbRepositoryImplTest {

    @RelaxedMockK
    private lateinit var mdbRestDatasource: MdbRestDatasource

    private lateinit var sut: MdbRepositoryImpl

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)

        sut = MdbRepositoryImpl(mdbRestDatasource)
    }

    @Test
    fun `getConfiguration invokes api method the first time`() {
        val testObserver = TestObserver<ConfigurationResponseDto>()
        every { mdbRestDatasource.getConfiguration() }
            .returns(Observable.just(DtoModelsMother.ANY_CONFIGURATION_DTO))

        sut.getConfiguration()
            .subscribe(testObserver)

        testObserver.assertResult(ANY_CONFIGURATION_DTO)
        verify { mdbRestDatasource.getConfiguration() }
    }

    @Test
    fun `multiple values of getConfiguration invokes api method only once`() {
        val testObserver = TestObserver<ConfigurationResponseDto>()
        every { mdbRestDatasource.getConfiguration() }
            .returns(Observable.just(ANY_CONFIGURATION_DTO, ANY_CONFIGURATION_DTO))

        sut.getConfiguration()
            .subscribe(testObserver)

        testObserver.assertResult(ANY_CONFIGURATION_DTO, ANY_CONFIGURATION_DTO)
        verify(exactly = 1) { mdbRestDatasource.getConfiguration() }
    }

    @Test
    fun `getTopRatedShows invokes api method`() {
        val testObserver = TestObserver<PaginatedResponseDto<TvShowDto>>()
        every { mdbRestDatasource.getTopRatedShows(6) }
            .returns(Observable.just(ANY_PAGINATED_RESPONSE_DTO))

        sut.getTopRatedShows(6)
            .subscribe(testObserver)

        testObserver.assertResult(ANY_PAGINATED_RESPONSE_DTO)
        verify { mdbRestDatasource.getTopRatedShows(6) }
    }
}
