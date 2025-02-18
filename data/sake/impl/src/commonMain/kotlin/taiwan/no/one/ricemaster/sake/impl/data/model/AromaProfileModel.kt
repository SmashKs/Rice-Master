package taiwan.no.one.ricemaster.sake.impl.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import taiwan.no.one.ricemaster.sake.api.entity.AromaProfileEntity

@Serializable
@Entity(tableName = "aroma_profiles")
internal data class AromaProfileModel(
    @PrimaryKey(autoGenerate = true)
    val aromaProfileId: Long = 0,
    val name: String,
    val description: String?,
) : Model {
    override fun toEntity(): AromaProfileEntity = AromaProfileEntity(
        id = aromaProfileId,
        name = name,
        description = description.orEmpty(),
    )
}
