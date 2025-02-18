package taiwan.no.one.ricemaster.sake.impl.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import taiwan.no.one.ricemaster.sake.api.entity.FlavorProfileEntity

@Serializable
@Entity(tableName = "flavor_profiles")
internal data class FlavorProfileModel(
    @PrimaryKey(autoGenerate = true)
    val flavorProfileId: Long = 0,
    val name: String,
    val description: String,
) : Model {
    override fun toEntity(): FlavorProfileEntity = FlavorProfileEntity(
        id = flavorProfileId,
        name = name,
        description = description,
    )
}
