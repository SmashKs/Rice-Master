package taiwan.no.one.ricemaster.sake.impl.data.model.relation

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "sake_aroma_cross_ref",
    primaryKeys = ["sakeId", "aromaId"],
)
internal data class SakeAromaCrossRef(
    @ColumnInfo(index = true)
    val sakeId: Long,
    @ColumnInfo(index = true)
    val aromaId: Long,
)
