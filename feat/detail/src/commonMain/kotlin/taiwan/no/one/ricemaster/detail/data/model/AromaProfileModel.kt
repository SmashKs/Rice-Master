package taiwan.no.one.ricemaster.detail.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "aroma_profiles")
data class AromaProfileModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val description: String?,
)
