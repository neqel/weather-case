package no.patrik.weathercase.weatherservice.openweathermap.client

import no.patrik.weathercase.weatherservice.openweathermap.type.CurrentWeatherDataResponse
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class OpenWeatherMapClient(private val openWeatherMapWebClient: WebClient, private val openWeatherMapConfig: OpenWeatherMapConfig) {

    fun getCurrentWeatherData(lat: String, lon: String): CurrentWeatherDataResponse =
            openWeatherMapWebClient.get()
                    .uri { uriBuilder ->
                        uriBuilder
                                .path("/data/2.5/weather")
                                .queryParam("lat", lat)
                                .queryParam("lon", lon)
                                .queryParam("appid", openWeatherMapConfig.apiKey)
                                .build()
                    }
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(CurrentWeatherDataResponse::class.java)
                    .block() ?: throw Exception("Exception when calling Open Weather Map")
}