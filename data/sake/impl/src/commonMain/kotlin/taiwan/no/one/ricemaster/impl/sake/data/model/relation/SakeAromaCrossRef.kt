package taiwan.no.one.ricemaster.impl.sake.data.model.relation

import androidx.room.Entity

@Entity(primaryKeys = ["sakeId", "aromaId"])
internal data class SakeAromaCrossRef(
    val sakeId: Long,
    val aromaId: Long,
)
