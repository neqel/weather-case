package no.patrik.weathercase.weatherservice.met.client

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "met")
data class MetConfig(
        val baseUrl: String
)
