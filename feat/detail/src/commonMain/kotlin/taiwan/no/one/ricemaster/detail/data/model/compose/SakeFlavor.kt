package taiwan.no.one.ricemaster.detail.data.model.compose

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import taiwan.no.one.ricemaster.detail.data.model.FlavorProfile
import taiwan.no.one.ricemaster.detail.data.model.Sake

@Entity(
    tableName = "sake_flavors",
    foreignKeys = [
        ForeignKey(entity = Sake::class, parentColumns = ["id"], childColumns = ["sakeId"]),
        ForeignKey(entity = FlavorProfile::class, parentColumns = ["id"], childColumns = ["flavorId"]),
    ],
)
data class SakeFlavor(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val sakeId: Long,
    val flavorId: Long,
)
