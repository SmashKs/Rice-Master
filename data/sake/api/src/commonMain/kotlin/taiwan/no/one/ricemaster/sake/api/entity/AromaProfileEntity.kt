package taiwan.no.one.ricemaster.sake.api.entity

data class AromaProfileEntity(
    val id: Long = 0,
    val name: String,
    val description: String,
) : Entity
