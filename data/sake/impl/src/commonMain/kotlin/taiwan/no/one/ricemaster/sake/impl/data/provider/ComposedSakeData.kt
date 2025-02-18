package taiwan.no.one.ricemaster.sake.impl.data.provider

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import taiwan.no.one.ricemaster.sake.impl.data.model.AromaProfileModel
import taiwan.no.one.ricemaster.sake.impl.data.model.AwardModel
import taiwan.no.one.ricemaster.sake.impl.data.model.BreweryModel
import taiwan.no.one.ricemaster.sake.impl.data.model.FlavorProfileModel
import taiwan.no.one.ricemaster.sake.impl.data.model.ImageModel
import taiwan.no.one.ricemaster.sake.impl.data.model.SakeModel
import taiwan.no.one.ricemaster.sake.impl.data.model.SpeciallyDesignatedSakeModel

@Serializable
internal data class ComposedSakeData(
    val breweries: List<BreweryModel>,
    val speciallyDesignatedSakes: List<SpeciallyDesignatedSakeModel>,
    val flavorProfiles: List<FlavorProfileModel>,
    val aromaProfiles: List<AromaProfileModel>,
    val awards: List<AwardModel>,
    val sakes: List<SakeModel>,
    val images: List<ImageModel>,
)

internal fun parseSakeDataJson(): ComposedSakeData {
    return Json.decodeFromString(ComposedSakeData.serializer(), fakeDataJson)
}
