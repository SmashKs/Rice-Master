package taiwan.no.one.ricemaster.sake.api.entity

import kotlinx.datetime.Instant

data class SakeEntity(
    val id: Long = 0,
    val name: String,
    val abv: Float, // Alcohol By Volume
    val polishingRatio: Float,
    val brewDate: Instant,
    val expirationDate: Instant,
    val priceRange: String,
    val description: String,
)
