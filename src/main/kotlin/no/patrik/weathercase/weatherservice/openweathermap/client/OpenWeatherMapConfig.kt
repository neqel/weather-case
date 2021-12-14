package no.patrik.weathercase.weatherservice.openweathermap.client

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "open-weather-map")
data class OpenWeatherMapConfig(
        val baseUrl: String,
        val apiKey: String
)
