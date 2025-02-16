package taiwan.no.one.ricemaster.sake.api.entity

data class BreweryEntity(
    val id: Long = 0,
    val name: String,
    val location: String,
    val description: String,
    val website: String,
)
