package taiwan.no.one.ricemaster.impl.sake.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "specially_designated_sake")
internal data class SpeciallyDesignatedSakeModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String, // e.g., Junmai, Ginjo, Daiginjo, etc.
    val description: String?,
)
