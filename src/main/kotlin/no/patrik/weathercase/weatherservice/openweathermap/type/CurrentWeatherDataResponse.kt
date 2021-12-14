package no.patrik.weathercase.weatherservice.openweathermap.type

import com.fasterxml.jackson.annotation.JsonProperty

data class CurrentWeatherDataResponse(
        val coord: Coord,
        val main: Data,
        val rain: Rain? = null,
        val snow: Snow? = null
)

data class Coord(
        val lat: String? = null,
        val lon: String? = null
)

data class Data(
        val temp: Double? = null,
        val feels_like: Double? = null,
        val temp_min: Double? = null,
        val temp_max: Double? = null,
        val pressure: Double? = null,
        val humidity: Double? = null
)

data class Rain(
        @JsonProperty("1h")
        val oneH: Double? = null
)

data class Snow(
        @JsonProperty("1h")
        val oneH: Double? = null
)
