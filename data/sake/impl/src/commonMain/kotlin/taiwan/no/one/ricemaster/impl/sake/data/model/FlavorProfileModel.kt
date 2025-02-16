package taiwan.no.one.ricemaster.impl.sake.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "flavor_profiles")
internal data class FlavorProfileModel(
    @PrimaryKey(autoGenerate = true)
    val flavorProfileId: Long = 0,
    val name: String,
    val description: String,
)
