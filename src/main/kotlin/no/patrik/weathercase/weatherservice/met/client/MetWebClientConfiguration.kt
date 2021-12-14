package no.patrik.weathercase.weatherservice.met.client

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class MetWebClientConfiguration(private val metConfigConfig: MetConfig) {

    @Bean
    fun metWebClient(webClientBuilder: WebClient.Builder): WebClient {
        return webClientBuilder
                .baseUrl(metConfigConfig.baseUrl)
                .build()

    }
}