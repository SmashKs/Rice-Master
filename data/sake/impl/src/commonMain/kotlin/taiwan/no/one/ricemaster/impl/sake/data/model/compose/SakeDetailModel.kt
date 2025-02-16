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

internal data class SakeDetailModel(
    @Embedded
    val sake: SakeModel,
    @Relation(
        parentColumn = "breweryId",
        entityColumn = "breweryId",
        entity = BreweryModel::class,
    )
    val brewery: BreweryModel,
    @Relation(
        parentColumn = "speciallyDesignatedId",
        entityColumn = "speciallyDesignatedSakeId",
        entity = SpeciallyDesignatedSakeModel::class,
    )
    val speciallyDesignatedSake: SpeciallyDesignatedSakeModel,
    @Relation(
        parentColumn = "sakeId", // This is the primary key of the SakeModel
        entityColumn = "sakeId", // This is the foreign key in the ImageModel
    )
    val images: List<ImageModel>,
    @Relation(
        parentColumn = "sakeId", // SakeModel's primary key
        entityColumn = "flavorProfileId", // FlavorModel's primary key
        associateBy = Junction(
            value = SakeFlavorCrossRef::class,
            parentColumn = "sakeId", // Foreign key of Sake in the junction table
            entityColumn = "flavorId", // Foreign key of Flavor in the junction table
        ),
    )
    val flavorProfiles: List<FlavorProfileModel>,
    @Relation(
        parentColumn = "sakeId", // SakeModel's primary key
        entityColumn = "aromaProfileId", // AromaModel's primary key
        associateBy = Junction(
            value = SakeAromaCrossRef::class,
            parentColumn = "sakeId", // Foreign key of Sake in the junction table
            entityColumn = "aromaId", // Foreign key of Aroma in the junction table
        ),
    )
    val aromaProfiles: List<AromaProfileModel>,
    @Relation(
        parentColumn = "sakeId", // SakeModel's primary key
        entityColumn = "awardId", // AwardModel's primary key
        associateBy = Junction(
            value = SakeAwardCrossRef::class,
            parentColumn = "sakeId", // Foreign key of Sake in the junction table
            entityColumn = "awardId", // Foreign key of Award in the junction table
        ),
    )
    val awards: List<AwardModel>,
)
