package taiwan.no.one.ricemaster.impl.sake.data.model.relation

import androidx.room.Entity

@Entity(primaryKeys = ["sakeId", "awardId"])
internal data class SakeAwardCrossRef(
    val sakeId: Long,
    val awardId: Long,
)
