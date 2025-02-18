package taiwan.no.one.ricemaster.favorite.impl.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

@Entity(
    tableName = "favorite",
    primaryKeys = ["user_id", "sake_id"],
)
internal data class FavoriteModel(
    // identifier for the user who favorites an item
    @ColumnInfo(name = "user_id")
    val userId: String,
    // identifier for the item
    @ColumnInfo(name = "sake_id")
    val sakeId: String,
    // A timestamp (in milliseconds) for when the favorite was added.
    @ColumnInfo(name = "created_at")
    val createdAt: Instant = Clock.System.now(),
)
