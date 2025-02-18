package taiwan.no.one.ricemaster.sake.impl.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import taiwan.no.one.ricemaster.sake.api.entity.SpeciallyDesignatedSakeEntity

@Serializable
@Entity(tableName = "specially_designated_sake")
internal data class SpeciallyDesignatedSakeModel(
    @PrimaryKey(autoGenerate = true)
    val speciallyDesignatedSakeId: Long = 0,
    val name: String, // e.g., Junmai, Ginjo, Daiginjo, etc.
    val description: String?,
) : Model {
    override fun toEntity(): SpeciallyDesignatedSakeEntity = SpeciallyDesignatedSakeEntity(
        id = speciallyDesignatedSakeId,
        name = name,
        description = description.orEmpty(),
    )
}
