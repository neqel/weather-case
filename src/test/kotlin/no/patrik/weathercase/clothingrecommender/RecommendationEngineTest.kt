package no.patrik.weathercase.clothingrecommender

import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RecommendationEngineTest {

    private val log = LoggerFactory.getLogger(javaClass)

    @Autowired
    private lateinit var recommendationEngine: RecommendationEngine

    @Test
    fun weather_responses_test() {
        val recommendation = recommendationEngine.recommendClothing("59.9139", "10.7522")
        log.info("Recommended clothing: $recommendation")
    }
}