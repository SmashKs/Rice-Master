package taiwan.no.one.ricemaster.detail.data.model.compose

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import taiwan.no.one.ricemaster.detail.data.model.SakeModel

@Entity(
    tableName = "sake_awards",
    foreignKeys = [
        ForeignKey(entity = SakeModel::class, parentColumns = ["id"], childColumns = ["sakeId"]),
    ],
)
data class SakeAwardModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val sakeId: Long,
    val awardName: String,
    val year: Int,
)
