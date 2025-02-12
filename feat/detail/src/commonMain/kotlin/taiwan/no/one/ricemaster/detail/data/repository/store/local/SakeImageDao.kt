package taiwan.no.one.ricemaster.detail.data.repository.store.local

import androidx.room.Dao
import androidx.room.Query
import taiwan.no.one.ricemaster.detail.data.model.compose.SakeImage
import taiwan.no.one.ricemaster.persistence.data.BaseDao

@Dao
interface SakeImageDao : BaseDao<SakeImage> {
    @Query("SELECT * FROM sake_images WHERE id = :id LIMIT 1")
    suspend fun getSakeImageById(id: Long): SakeImage?

    @Query("SELECT * FROM sake_images WHERE sakeId = :sakeId")
    suspend fun getImagesForSake(sakeId: Long): List<SakeImage>

    @Query("SELECT * FROM sake_images")
    suspend fun getAllSakeImages(): List<SakeImage>
}
