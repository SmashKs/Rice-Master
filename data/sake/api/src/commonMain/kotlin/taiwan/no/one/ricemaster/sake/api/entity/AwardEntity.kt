package taiwan.no.one.ricemaster.sake.api.entity

data class AwardEntity(
    val id: Long = 0,
    val awardName: String,
    val year: Int,
) : Entity
