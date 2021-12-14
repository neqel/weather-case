package no.patrik.weathercase.weatherservice.openweathermap.client

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class OpenWeatherMapWebClientConfiguration(private val openWeatherMapConfig: OpenWeatherMapConfig) {

    @Bean
    fun openWeatherMapWebClient(webClientBuilder: WebClient.Builder): WebClient {
        return webClientBuilder
                .baseUrl(openWeatherMapConfig.baseUrl)
                .build()

    }
}