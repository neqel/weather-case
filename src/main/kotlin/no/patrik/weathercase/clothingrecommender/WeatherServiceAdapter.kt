package no.patrik.weathercase.clothingrecommender

interface WeatherServiceAdapter {

    fun fetchForecast(lat: String, lon: String): Any

    fun getAirTemperature(forecast: Any): Double?

    fun getPrecipitation(forecast: Any): Double
}