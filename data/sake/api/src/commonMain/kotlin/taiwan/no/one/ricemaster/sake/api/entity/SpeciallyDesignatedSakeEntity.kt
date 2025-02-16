package taiwan.no.one.ricemaster.sake.api.entity

data class SpeciallyDesignatedSakeEntity(
    val id: Long = 0,
    val name: String, // e.g., Junmai, Ginjo, Daiginjo, etc.
    val description: String,
)
