package no.patrik.weathercase.weatherservice.met.type

import com.fasterxml.jackson.databind.JsonNode
import java.time.OffsetDateTime

data class METJsonForecast(
        val type: String,
        val geometry: PointGeometry,
        val properties: Forecast
)

data class Forecast(
        val meta: Meta,
        val timeseries: List<ForecastTimeStep>
)

data class PointGeometry(
        val type: String,
        val coordinates: List<String>
)

data class Meta(
        val updated_at: OffsetDateTime,
        val units: ForecastUnits
)

data class ForecastTimeStep(
        val time: OffsetDateTime,
        val data: ForecastTimeStepData
)

data class ForecastUnits(
        val air_pressure_at_sea_level: String? = null,
        val air_temperature: String? = null,
        val cloud_area_fraction: String? = null,
        val precipitation_amount: String? = null,
        val relative_humidity: String? = null,
        val wind_from_direction: String? = null,
        val wind_speed: String? = null
)

data class ForecastTimeStepData(
        val instant: ForecastTimeInstant,
        val next_1_hours: JsonNode? = null
)

data class ForecastTimeInstant(
        val details: ForecastTimeInstantDetails? = null
)

data class ForecastTimeInstantDetails(
        val air_pressure_at_sea_level: Double? = null,
        val air_temperature: Double? = null,
        val cloud_area_fraction: Double? = null,
        val relative_humidity: Double? = null,
        val wind_from_direction: Double? = null,
        val wind_speed: Double? = null
)
