package no.patrik.weathercase.weatherservice.met.client

import no.patrik.weathercase.weatherservice.met.type.METJsonForecast
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class MetClient(private val metWebClient: WebClient) {

    fun getLocationForecastCompact(lat: String, lon: String): METJsonForecast =
            metWebClient.get()
                    .uri { uriBuilder ->
                        uriBuilder
                                .path("/weatherapi/locationforecast/2.0/compact")
                                .queryParam("lat", lat)
                                .queryParam("lon", lon)
                                .build()
                    }
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(METJsonForecast::class.java)
                    .block() ?: throw Exception("Exception when calling MET")
}