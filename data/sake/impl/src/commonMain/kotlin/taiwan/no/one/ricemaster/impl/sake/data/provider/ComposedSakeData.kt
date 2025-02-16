package taiwan.no.one.ricemaster.impl.sake.data.provider

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import taiwan.no.one.ricemaster.impl.sake.data.model.AromaProfileModel
import taiwan.no.one.ricemaster.impl.sake.data.model.AwardModel
import taiwan.no.one.ricemaster.impl.sake.data.model.BreweryModel
import taiwan.no.one.ricemaster.impl.sake.data.model.FlavorProfileModel
import taiwan.no.one.ricemaster.impl.sake.data.model.ImageModel
import taiwan.no.one.ricemaster.impl.sake.data.model.SakeModel
import taiwan.no.one.ricemaster.impl.sake.data.model.SpeciallyDesignatedSakeModel

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

internal fun parseJson(): ComposedSakeData {
    return Json.decodeFromString(ComposedSakeData.serializer(), fakeDataJson)
}
