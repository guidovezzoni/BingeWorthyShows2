package com.guidovezzoni.bingeworthyshow2.data.datasource

import com.guidovezzoni.bingeworthyshow2.data.api.MdbApi
import com.guidovezzoni.bingeworthyshow2.data.dto.ConfigurationResponseDto
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
        val testObserver = TestObserver<ConfigurationResponseDto>()
        every { api.getConfiguration(API_KEY) }
            .returns(Observable.just(ANY_CONFIGURATION_DTO))

        sut.getConfiguration()
            .subscribe(testObserver)

        testObserver.assertResult(ANY_CONFIGURATION_DTO)  // includes .assertComplete().assertNoErrors()
        verify { api.getConfiguration(API_KEY) }
    }

    @Test
    fun `getTopRatedShows invokes api method`() {
        val testObserver = TestObserver<PaginatedResponseDto<TvShowDto>>()
        every { api.getTopRatedShows(API_KEY, 6) }
            .returns(Observable.just(ANY_PAGINATED_RESPONSE_DTO))

        sut.getTopRatedShows(6)
            .subscribe(testObserver)

        testObserver.assertResult(ANY_PAGINATED_RESPONSE_DTO)
        verify { api.getTopRatedShows(API_KEY, 6) }
    }

    companion object {
        private const val API_KEY = "a key"
    }
}
