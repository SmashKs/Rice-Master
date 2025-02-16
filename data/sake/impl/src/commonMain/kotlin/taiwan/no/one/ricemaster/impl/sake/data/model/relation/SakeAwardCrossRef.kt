package taiwan.no.one.ricemaster.impl.sake.data.model.relation

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "sake_award_cross_ref",
    primaryKeys = ["sakeId", "awardId"],
)
internal data class SakeAwardCrossRef(
    @ColumnInfo(index = true)
    val sakeId: Long, // Foreign key from SakeModel
    @ColumnInfo(index = true)
    val awardId: Long, // Foreign key from AwardModel
)
