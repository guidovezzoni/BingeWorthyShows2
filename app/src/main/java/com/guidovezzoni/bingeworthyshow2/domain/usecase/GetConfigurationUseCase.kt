package com.guidovezzoni.bingeworthyshow2.domain.usecase

import com.guidovezzoni.bingeworthyshow2.data.dto.toConfigurationDomainModel
import com.guidovezzoni.bingeworthyshow2.domain.model.ConfigurationDomainModel
import com.guidovezzoni.bingeworthyshow2.domain.repository.MdbRepository
import io.reactivex.rxjava3.core.Observable

class GetConfigurationUseCase(private val repository: MdbRepository) {

    operator fun invoke(): Observable<ConfigurationDomainModel> =
        repository.getConfiguration()
            .map { it.toConfigurationDomainModel() }
}
