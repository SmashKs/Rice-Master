package taiwan.no.one.ricemaster.impl.sake.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.datetime.Instant

@Entity(
    tableName = "sake",
    foreignKeys = [
        ForeignKey(
            entity = BreweryModel::class,
            parentColumns = ["breweryId"],
            childColumns = ["breweryId"],
        ),
        ForeignKey(
            entity = SpeciallyDesignatedSakeModel::class,
            parentColumns = ["speciallyDesignatedSakeId"],
            childColumns = ["speciallyDesignatedId"],
        ),
    ],
    ignoredColumns = ["flavorIds", "aromaIds", "awardIds"],
)
internal data class SakeModel(
    @PrimaryKey(autoGenerate = true)
    val sakeId: Long = 0,
    val name: String,
    val abv: Float, // Alcohol By Volume
    val polishingRatio: Float,
    val brewDate: Instant?,
    val expirationDate: Instant?,
    val priceRange: String?,
    val description: String?,
    //region Foreign keys for relationships
    @ColumnInfo(index = true)
    val speciallyDesignatedId: Long,
    @ColumnInfo(index = true)
    val breweryId: Long,
    //endregion
    //region Ignored keys
    val flavorIds: List<Long>,
    val aromaIds: List<Long>,
    val awardIds: List<Long>,
    //endregion
) {
    constructor(
        sakeId: Long = 0,
        name: String,
        abv: Float,
        polishingRatio: Float,
        brewDate: Instant?,
        expirationDate: Instant?,
        priceRange: String?,
        description: String?,
        speciallyDesignatedId: Long,
        breweryId: Long,
    ) : this(
        sakeId,
        name,
        abv,
        polishingRatio,
        brewDate,
        expirationDate,
        priceRange,
        description,
        speciallyDesignatedId,
        breweryId,
        emptyList(),
        emptyList(),
        emptyList(),
    )
}
