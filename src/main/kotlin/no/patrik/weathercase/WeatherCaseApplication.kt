package no.patrik.weathercase

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class WeatherCaseApplication

fun main(args: Array<String>) {
	runApplication<WeatherCaseApplication>(*args)
}
