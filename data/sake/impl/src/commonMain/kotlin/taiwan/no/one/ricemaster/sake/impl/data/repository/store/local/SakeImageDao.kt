package taiwan.no.one.ricemaster.sake.impl.data.repository.store.local

import androidx.room.Dao
import androidx.room.Query
import taiwan.no.one.ricemaster.persistence.data.BaseDao
import taiwan.no.one.ricemaster.sake.impl.data.model.ImageModel

@Dao
internal interface SakeImageDao : BaseDao<ImageModel> {
    @Query("SELECT * FROM sake_images WHERE imageId = :id LIMIT 1")
    suspend fun getSakeImageById(id: Long): ImageModel?

    @Query("SELECT * FROM sake_images")
    suspend fun getAllSakeImages(): List<ImageModel>
}
