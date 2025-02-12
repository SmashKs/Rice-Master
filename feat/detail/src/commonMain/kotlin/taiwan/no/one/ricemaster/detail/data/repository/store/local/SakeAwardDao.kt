package taiwan.no.one.ricemaster.detail.data.repository.store.local

import androidx.room.Dao
import androidx.room.Query
import taiwan.no.one.ricemaster.detail.data.model.compose.SakeAward
import taiwan.no.one.ricemaster.persistence.data.BaseDao

@Dao
interface SakeAwardDao : BaseDao<SakeAward> {
    @Query("SELECT * FROM sake_awards WHERE id = :id LIMIT 1")
    suspend fun getSakeAwardById(id: Long): SakeAward?

    @Query("SELECT * FROM sake_awards WHERE sakeId = :sakeId")
    suspend fun getAwardsForSake(sakeId: Long): List<SakeAward>

    @Query("SELECT * FROM sake_awards")
    suspend fun getAllSakeAwards(): List<SakeAward>
}
