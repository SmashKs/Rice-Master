package taiwan.no.one.ricemaster.sake.impl.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import taiwan.no.one.ricemaster.sake.api.entity.ImageEntity

@Serializable
@Entity(tableName = "sake_images")
internal data class ImageModel(
    @PrimaryKey(autoGenerate = true)
    val imageId: Long = 0,
    val imageUrl: String,
    val description: String,
    @ColumnInfo(index = true)
    val sakeId: Long, // Foreign key that references the SakeModel
) : Model {
    override fun toEntity(): ImageEntity = ImageEntity(
        id = imageId,
        imageUrl = imageUrl,
        description = description,
    )
}
