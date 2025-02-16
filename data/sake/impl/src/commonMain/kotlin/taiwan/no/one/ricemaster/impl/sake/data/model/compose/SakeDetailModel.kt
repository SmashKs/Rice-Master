package taiwan.no.one.ricemaster.impl.sake.data.model.compose

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import taiwan.no.one.ricemaster.impl.sake.data.model.AromaProfileModel
import taiwan.no.one.ricemaster.impl.sake.data.model.AwardModel
import taiwan.no.one.ricemaster.impl.sake.data.model.BreweryModel
import taiwan.no.one.ricemaster.impl.sake.data.model.FlavorProfileModel
import taiwan.no.one.ricemaster.impl.sake.data.model.ImageModel
import taiwan.no.one.ricemaster.impl.sake.data.model.SakeModel
import taiwan.no.one.ricemaster.impl.sake.data.model.SpeciallyDesignatedSakeModel
import taiwan.no.one.ricemaster.impl.sake.data.model.relation.SakeAromaCrossRef
import taiwan.no.one.ricemaster.impl.sake.data.model.relation.SakeAwardCrossRef
import taiwan.no.one.ricemaster.impl.sake.data.model.relation.SakeFlavorCrossRef
import taiwan.no.one.ricemaster.impl.sake.data.model.relation.SakeImageCrossRef

internal data class SakeDetailModel(
    @Embedded
    val sake: SakeModel,
    @Relation(
        parentColumn = "breweryId",
        entityColumn = "id",
        entity = BreweryModel::class,
    )
    val brewery: BreweryModel,
    @Relation(
        parentColumn = "speciallyDesignatedId",
        entityColumn = "id",
        entity = SpeciallyDesignatedSakeModel::class,
    )
    val speciallyDesignatedSake: SpeciallyDesignatedSakeModel,
    @Relation(
        parentColumn = "sakeId",
        entityColumn = "imageId",
        associateBy = Junction(SakeImageCrossRef::class),
    )
    val images: List<ImageModel>,
    @Relation(
        parentColumn = "sakeId",
        entityColumn = "flavorId",
        associateBy = Junction(SakeFlavorCrossRef::class),
    )
    val flavorProfiles: List<FlavorProfileModel>,
    @Relation(
        parentColumn = "sakeId",
        entityColumn = "aromaId",
        associateBy = Junction(SakeAromaCrossRef::class),
    )
    val aromaProfiles: List<AromaProfileModel>,
    @Relation(
        parentColumn = "awardIds",
        entityColumn = "awardId",
        associateBy = Junction(SakeAwardCrossRef::class),
    )
    val awards: List<AwardModel>,
)
