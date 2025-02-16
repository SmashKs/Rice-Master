package taiwan.no.one.ricemaster.impl.sake.data.model.relation

import androidx.room.Entity

@Entity(primaryKeys = ["sakeId", "flavorId"])
internal data class SakeFlavorCrossRef(
    val sakeId: Long,
    val flavorId: Long,
)
