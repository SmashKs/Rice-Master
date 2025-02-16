package taiwan.no.one.ricemaster.impl.sake.data.model.relation

import androidx.room.Entity

@Entity(primaryKeys = ["sakeId", "imageId"])
internal data class SakeImageCrossRef(
    val sakeId: Long,
    val imageId: Long,
)
