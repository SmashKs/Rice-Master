package taiwan.no.one.ricemaster.impl.sake.data.model.compose

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import taiwan.no.one.ricemaster.impl.sake.data.model.AromaProfileModel
import taiwan.no.one.ricemaster.impl.sake.data.model.SakeModel

@Entity(
    tableName = "sake_aromas",
    foreignKeys = [
        ForeignKey(entity = SakeModel::class, parentColumns = ["id"], childColumns = ["sakeId"]),
        ForeignKey(entity = AromaProfileModel::class, parentColumns = ["id"], childColumns = ["aromaId"]),
    ],
)
internal data class SakeAromaModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val sakeId: Long,
    val aromaId: Long,
)
