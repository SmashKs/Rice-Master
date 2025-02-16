package taiwan.no.one.ricemaster.impl.sake.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.datetime.Instant

@Entity(
    tableName = "sake",
    foreignKeys = [
        ForeignKey(entity = BreweryModel::class, parentColumns = ["id"], childColumns = ["breweryId"]),
        ForeignKey(
            entity = SpeciallyDesignatedSakeModel::class,
            parentColumns = ["id"],
            childColumns = ["speciallyDesignatedId"],
        ),
    ],
)
internal data class SakeModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val breweryId: Long,
    val speciallyDesignatedId: Long,
    val abv: Float, // Alcohol By Volume
    val polishingRatio: Float,
    val brewDate: Instant?,
    val expirationDate: Instant?,
    val priceRange: String?,
    val imageUrl: String?,
    val description: String?,
)
