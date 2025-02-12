package taiwan.no.one.ricemaster.detail.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.datetime.Instant

@Entity(
    tableName = "sake",
    foreignKeys = [
        ForeignKey(entity = Brewery::class, parentColumns = ["id"], childColumns = ["breweryId"]),
        ForeignKey(
            entity = SpeciallyDesignatedSake::class,
            parentColumns = ["id"],
            childColumns = ["speciallyDesignatedId"],
        ),
    ],
)
data class Sake(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val breweryId: Long,
    val speciallyDesignatedId: Long,
    val abv: Float, // Alcohol By Volume
    val polishingRatio: Float,
    val brewDate: String?, // Store as a String or add a Date type with converters
    val expirationDate: Instant?,
    val priceRange: String?,
    val imageUrl: String?,
    val description: String?,
)
