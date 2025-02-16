package taiwan.no.one.ricemaster.impl.sake.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "aroma_profiles")
internal data class AromaProfileModel(
    @PrimaryKey(autoGenerate = true)
    val aromaProfileId: Long = 0,
    val name: String,
    val description: String?,
)
