package taiwan.no.one.ricemaster.detail.data.model.compose

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import taiwan.no.one.ricemaster.detail.data.model.AromaProfile
import taiwan.no.one.ricemaster.detail.data.model.Sake

@Entity(
    tableName = "sake_aromas",
    foreignKeys = [
        ForeignKey(entity = Sake::class, parentColumns = ["id"], childColumns = ["sakeId"]),
        ForeignKey(entity = AromaProfile::class, parentColumns = ["id"], childColumns = ["aromaId"]),
    ],
)
data class SakeAroma(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val sakeId: Long,
    val aromaId: Long,
)
