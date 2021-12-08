package com.guidovezzoni.bingeworthyshow2.domain.model

import com.guidovezzoni.bingeworthyshow2.domain.model.ConfigurationDomainModelMother.ANY_CONFIGURATION_DOMAIN_MODEL
import com.guidovezzoni.bingeworthyshow2.domain.model.ConfigurationDomainModelMother.LOWER_RES_CONFIGURATION_DOMAIN_MODEL
import com.guidovezzoni.bingeworthyshow2.domain.model.ConfigurationDomainModelMother.ORIGINAL_CONFIGURATION_DOMAIN_MODEL
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test

class ExtensionsKtTest {

    @Test
    fun `getBestPosterSize returns w780`() {
        val actual = ANY_CONFIGURATION_DOMAIN_MODEL.getBestPosterSize()

        assertEquals("w780", actual)
    }

    @Test
    fun `getBestPosterSize returns highest available res`() {
        val actual = LOWER_RES_CONFIGURATION_DOMAIN_MODEL.getBestPosterSize()

        assertEquals("w342", actual)
    }

    @Test
    fun `getBestPosterSize returns original if it's the only available`() {
        val actual = ORIGINAL_CONFIGURATION_DOMAIN_MODEL.getBestPosterSize()

        assertEquals("original", actual)
    }
}
