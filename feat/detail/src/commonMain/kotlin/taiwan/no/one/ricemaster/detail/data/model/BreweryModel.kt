package taiwan.no.one.ricemaster.detail.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "breweries")
data class BreweryModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val location: String,
    val description: String?,
    val website: String?,
)
