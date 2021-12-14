package no.patrik.weathercase.controller

import no.patrik.weathercase.clothingrecommender.RecommendationEngine
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/clothing-recommendations")
class ClothingRecommendationController(private val recommendationEngine: RecommendationEngine) {

    @GetMapping("/")
    fun getClothingRecommendation(@RequestParam("lat") lat: String, @RequestParam("lon") lon: String): ClothingRecommendationResponse {
        val recommendation = recommendationEngine.recommendClothing(lat, lon)

        return ClothingRecommendationResponse(recommendation)
    }

    data class ClothingRecommendationResponse(
            val clothing: String
    )
}