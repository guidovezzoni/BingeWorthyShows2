package com.guidovezzoni.bingeworthyshow2.domain.usecase

import com.guidovezzoni.bingeworthyshow2.data.dto.DtoModelsMother.ANY_CONFIGURATION_DTO
import com.guidovezzoni.bingeworthyshow2.data.repository.MdbRepository
import com.guidovezzoni.bingeworthyshow2.domain.model.ConfigurationDomainModel
import com.guidovezzoni.bingeworthyshow2.domain.model.DomainModelsMother.ANY_CONFIGURATION_DOMAIN_MODEL
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.TestObserver
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GetConfigurationUseCaseTest {

    @RelaxedMockK
    private lateinit var mdbRepository: MdbRepository

    private lateinit var sut: GetConfigurationUseCase

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)

        sut = GetConfigurationUseCase(mdbRepository)
    }

    @Test
    fun `getTopRatedShows invokes api method`() {
        val testObserver = TestObserver<ConfigurationDomainModel>()
        every { mdbRepository.getConfiguration() }
            .returns(Observable.just(ANY_CONFIGURATION_DTO))

        sut().subscribe(testObserver)

        testObserver.assertResult(ANY_CONFIGURATION_DOMAIN_MODEL)
        verify { mdbRepository.getConfiguration() }
    }
}
