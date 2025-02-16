package taiwan.no.one.ricemaster.impl.sake.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "breweries")
internal data class BreweryModel(
    @PrimaryKey(autoGenerate = true)
    val breweryId: Long = 0,
    val name: String,
    val location: String,
    val description: String?,
    val website: String?,
)
