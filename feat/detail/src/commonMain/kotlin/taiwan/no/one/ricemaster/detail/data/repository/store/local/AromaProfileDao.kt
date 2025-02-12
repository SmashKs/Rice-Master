package taiwan.no.one.ricemaster.detail.data.repository.store.local

import androidx.room.Dao
import androidx.room.Query
import taiwan.no.one.ricemaster.detail.data.model.AromaProfile
import taiwan.no.one.ricemaster.persistence.data.BaseDao

@Dao
interface AromaProfileDao : BaseDao<AromaProfile> {
    @Query("SELECT * FROM aroma_profiles WHERE id = :id LIMIT 1")
    suspend fun getAromaProfileById(id: Long): AromaProfile?

    @Query("SELECT * FROM aroma_profiles")
    suspend fun getAllAromaProfiles(): List<AromaProfile>
}
