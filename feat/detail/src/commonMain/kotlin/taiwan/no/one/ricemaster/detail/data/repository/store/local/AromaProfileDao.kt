package taiwan.no.one.ricemaster.detail.data.repository.store.local

import androidx.room.Dao
import androidx.room.Query
import taiwan.no.one.ricemaster.detail.data.model.AromaProfileModel
import taiwan.no.one.ricemaster.persistence.data.BaseDao

@Dao
interface AromaProfileDao : BaseDao<AromaProfileModel> {
    @Query("SELECT * FROM aroma_profiles WHERE id = :id LIMIT 1")
    suspend fun getAromaProfileById(id: Long): AromaProfileModel?

    @Query("SELECT * FROM aroma_profiles")
    suspend fun getAllAromaProfiles(): List<AromaProfileModel>
}
