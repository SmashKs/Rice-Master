package taiwan.no.one.ricemaster.impl.sake.data.model.relation

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "sake_flavor_cross_ref",
    primaryKeys = ["sakeId", "flavorId"],
)
internal data class SakeFlavorCrossRef(
    @ColumnInfo(index = true)
    val sakeId: Long, // Foreign key from SakeModel
    @ColumnInfo(index = true)
    val flavorId: Long, // Foreign key from FlavorModel
)
