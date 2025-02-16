package taiwan.no.one.ricemaster.impl.sake.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import taiwan.no.one.ricemaster.sake.api.entity.AwardEntity

@Serializable
@Entity(tableName = "sake_awards")
internal data class AwardModel(
    @PrimaryKey(autoGenerate = true)
    val awardId: Long = 0,
    val name: String,
    val year: Int,
) : Model {
    override fun toEntity(): AwardEntity = AwardEntity(
        id = awardId,
        awardName = name,
        year = year,
    )
}
