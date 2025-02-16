package taiwan.no.one.ricemaster.impl.sake.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import taiwan.no.one.ricemaster.sake.api.entity.BreweryEntity

@Serializable
@Entity(tableName = "breweries")
internal data class BreweryModel(
    @PrimaryKey(autoGenerate = true)
    val breweryId: Long = 0,
    val name: String,
    val location: String,
    val description: String?,
    val website: String?,
) : Model {
    override fun toEntity(): BreweryEntity = BreweryEntity(
        id = breweryId,
        name = name,
        location = location,
        description = description.orEmpty(),
        website = website.orEmpty(),
    )
}
