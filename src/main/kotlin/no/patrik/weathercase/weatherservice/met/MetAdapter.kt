package no.patrik.weathercase.weatherservice.met

import no.patrik.weathercase.clothingrecommender.WeatherServiceAdapter
import no.patrik.weathercase.weatherservice.met.client.MetClient
import no.patrik.weathercase.weatherservice.met.type.METJsonForecast
import org.springframework.stereotype.Component

@Component
class MetAdapter(private val metClient: MetClient) : WeatherServiceAdapter {

    override fun fetchForecast(lat: String, lon: String): Any {
        return metClient.getLocationForecastCompact(lat, lon)
    }

    override fun getAirTemperature(forecast: Any): Double? {
        return (forecast as? METJsonForecast)?.properties?.timeseries?.first()?.data?.instant?.details?.air_temperature
    }

    override fun getPrecipitation(forecast: Any): Double {
        return (forecast as? METJsonForecast)?.properties?.timeseries?.first()?.data?.next_1_hours?.at("/details/precipitation_amount")?.doubleValue() ?: 0.0
    }
}