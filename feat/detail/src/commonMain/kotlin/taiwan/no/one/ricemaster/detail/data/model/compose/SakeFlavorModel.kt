package taiwan.no.one.ricemaster.detail.data.model.compose

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import taiwan.no.one.ricemaster.detail.data.model.FlavorProfileModel
import taiwan.no.one.ricemaster.detail.data.model.SakeModel

@Entity(
    tableName = "sake_flavors",
    foreignKeys = [
        ForeignKey(entity = SakeModel::class, parentColumns = ["id"], childColumns = ["sakeId"]),
        ForeignKey(entity = FlavorProfileModel::class, parentColumns = ["id"], childColumns = ["flavorId"]),
    ],
)
data class SakeFlavorModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val sakeId: Long,
    val flavorId: Long,
)
