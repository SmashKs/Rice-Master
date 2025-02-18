package taiwan.no.one.ricemaster.sake.impl.data.repository.store.local

import androidx.room.Dao
import androidx.room.Query
import taiwan.no.one.ricemaster.persistence.data.BaseDao
import taiwan.no.one.ricemaster.sake.impl.data.model.AromaProfileModel

@Dao
internal interface AromaProfileDao : BaseDao<AromaProfileModel> {
    @Query("SELECT * FROM aroma_profiles WHERE aromaProfileId = :id LIMIT 1")
    suspend fun getAromaProfileById(id: Long): AromaProfileModel?

    @Query("SELECT * FROM aroma_profiles")
    suspend fun getAllAromaProfiles(): List<AromaProfileModel>
}
