package taiwan.no.one.ricemaster.impl.sake.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sake_awards")
internal data class AwardModel(
    @PrimaryKey(autoGenerate = true)
    val awardId: Long = 0,
    val name: String,
    val year: Int,
)
