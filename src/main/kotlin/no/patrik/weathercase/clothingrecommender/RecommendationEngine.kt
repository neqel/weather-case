package no.patrik.weathercase.clothingrecommender

import com.fasterxml.jackson.databind.ObjectMapper
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class RecommendationEngine(private val weatherServiceAdapters: List<WeatherServiceAdapter>, private val objectMapper: ObjectMapper) {

    private val log = LoggerFactory.getLogger(javaClass)

    fun recommendClothing(lat: String, lon: String): String {
        val (temperature, precipitation) = runBlocking {
            val forecasts = weatherServiceAdapters.map {
                async {
                    val forecast = it.fetchForecast(lat, lon)
                    val temperature = it.getAirTemperature(forecast)
                    val precipitation = it.getPrecipitation(forecast)

                    Pair(temperature, precipitation)
                }
            }.awaitAll()

            forecasts.forEach { (temperature, precipitation) ->
                log.info(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString("Temperature: $temperature C. Precipitation: $precipitation mm"))
            }

            val avgTemperature = forecasts.mapNotNull { (temperature, _) -> temperature }
                    .average()

            val avgPrecipitation = forecasts.map { (_, precipitation) -> precipitation }
                    .average()

            return@runBlocking Pair(avgTemperature, avgPrecipitation)
        }

        val recommendation = if (temperature < 4) {
            "winter clothes"
        } else if (temperature in 4.0..10.0) {
            "pants and jacket"
        } else if (temperature > 17) {
            "shorts"
        } else {
            "pants and sweater"
        }

        if (precipitation > 0.2 && temperature < 0) recommendation.plus("and umbrella")

        return recommendation
    }

}