package com.guidovezzoni.bingeworthyshow2.domain.usecase

import com.guidovezzoni.bingeworthyshow2.data.repository.MdbRepository
import com.guidovezzoni.bingeworthyshow2.domain.model.toConfigurationDomainModel

class GetConfigurationUseCase(private val repository: MdbRepository) {

    suspend operator fun invoke() = repository.getConfiguration().toConfigurationDomainModel()

}
