package com.guidovezzoni.bingeworthyshow2.domain.usecase

import com.guidovezzoni.bingeworthyshow2.domain.model.ConfigurationDomainModel
import com.guidovezzoni.bingeworthyshow2.domain.repository.MdbRepository
import kotlinx.coroutines.flow.Flow

class GetConfigurationUseCase(private val repository: MdbRepository) {
    @Deprecated("to be replaced by flow")
    suspend operator fun invoke(): ConfigurationDomainModel =
        repository.getConfiguration()

    suspend fun invoke2(): Flow<ConfigurationDomainModel> =
        repository.getConfiguration2()
}
