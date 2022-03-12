package com.guidovezzoni.bingeworthyshow2.domain.usecase

import com.guidovezzoni.bingeworthyshow2.data.repository.MdbRepository
import com.guidovezzoni.bingeworthyshow2.domain.model.ConfigurationDomainModel
import com.guidovezzoni.bingeworthyshow2.domain.model.toConfigurationDomainModel
import io.reactivex.rxjava3.core.Observable

class GetConfigurationUseCase(private val repository: MdbRepository) {

    operator fun invoke(): Observable<ConfigurationDomainModel> =
        repository.getConfiguration()
            .map { it.toConfigurationDomainModel() }
}
