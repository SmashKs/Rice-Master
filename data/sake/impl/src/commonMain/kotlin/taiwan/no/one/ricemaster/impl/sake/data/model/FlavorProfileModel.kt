package taiwan.no.one.ricemaster.impl.sake.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flavor_profiles")
internal data class FlavorProfileModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val description: String?,
)
