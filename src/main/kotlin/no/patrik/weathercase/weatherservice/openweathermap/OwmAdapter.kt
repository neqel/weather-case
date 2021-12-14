package no.patrik.weathercase.weatherservice.openweathermap

import no.patrik.weathercase.clothingrecommender.WeatherServiceAdapter
import no.patrik.weathercase.weatherservice.openweathermap.client.OpenWeatherMapClient
import no.patrik.weathercase.weatherservice.openweathermap.type.CurrentWeatherDataResponse
import org.springframework.stereotype.Component
import java.math.RoundingMode

@Component
class OwmAdapter(private val ownClient: OpenWeatherMapClient) : WeatherServiceAdapter {

    override fun fetchForecast(lat: String, lon: String): Any {
        return ownClient.getCurrentWeatherData(lat, lon)
    }

    override fun getAirTemperature(forecast: Any): Double? {
        return (forecast as? CurrentWeatherDataResponse)?.main?.feels_like?.minus(273.15)?.toBigDecimal()?.setScale(1, RoundingMode.HALF_UP)?.toDouble()
    }

    override fun getPrecipitation(forecast: Any): Double {
        return (forecast as? CurrentWeatherDataResponse)?.rain?.oneH ?: 0.0
    }
}