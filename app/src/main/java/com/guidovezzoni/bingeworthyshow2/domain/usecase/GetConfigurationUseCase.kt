package com.guidovezzoni.bingeworthyshow2.domain.usecase

import com.guidovezzoni.bingeworthyshow2.domain.model.ConfigurationDomainModel
import com.guidovezzoni.bingeworthyshow2.domain.repository.MdbRepository

class GetConfigurationUseCase(private val repository: MdbRepository) {

    suspend operator fun invoke(): ConfigurationDomainModel =
        repository.getConfiguration()

}
