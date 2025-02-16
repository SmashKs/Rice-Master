package taiwan.no.one.ricemaster.sake.api.entity

data class ImageEntity(
    val id: Long = 0,
    val imageUrl: String,
    val description: String,
) : Entity
