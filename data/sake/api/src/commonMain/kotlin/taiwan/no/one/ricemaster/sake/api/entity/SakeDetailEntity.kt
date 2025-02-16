package taiwan.no.one.ricemaster.sake.api.entity

data class SakeDetailEntity(
    val sake: SakeEntity,
    val brewery: BreweryEntity,
    val speciallyDesignatedSake: SpeciallyDesignatedSakeEntity,
    val images: List<ImageEntity>,
    val flavorProfiles: List<FlavorProfileEntity>,
    val aromaProfiles: List<AromaProfileEntity>,
    val awards: List<AwardEntity>,
)
