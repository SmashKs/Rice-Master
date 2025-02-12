package taiwan.no.one.ricemaster.detail.data.model.compose

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import taiwan.no.one.ricemaster.detail.data.model.Sake

@Entity(
    tableName = "sake_images",
    foreignKeys = [
        ForeignKey(entity = Sake::class, parentColumns = ["id"], childColumns = ["sakeId"]),
    ],
)
data class SakeImage(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val sakeId: Long,
    val imageUrl: String,
)
