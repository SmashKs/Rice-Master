package taiwan.no.one.ricemaster.impl.sake.data.repository.store.local

import androidx.room.Dao
import androidx.room.Query
import taiwan.no.one.ricemaster.impl.sake.data.model.compose.SakeImageModel
import taiwan.no.one.ricemaster.persistence.data.BaseDao

@Dao
internal interface SakeImageDao : BaseDao<SakeImageModel> {
    @Query("SELECT * FROM sake_images WHERE id = :id LIMIT 1")
    suspend fun getSakeImageById(id: Long): SakeImageModel?

    @Query("SELECT * FROM sake_images WHERE sakeId = :sakeId")
    suspend fun getImagesForSake(sakeId: Long): List<SakeImageModel>

    @Query("SELECT * FROM sake_images")
    suspend fun getAllSakeImages(): List<SakeImageModel>
}
