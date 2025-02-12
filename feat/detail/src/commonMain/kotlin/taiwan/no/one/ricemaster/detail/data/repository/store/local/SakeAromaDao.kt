package taiwan.no.one.ricemaster.detail.data.repository.store.local

import androidx.room.Dao
import androidx.room.Query
import taiwan.no.one.ricemaster.detail.data.model.compose.SakeAroma
import taiwan.no.one.ricemaster.persistence.data.BaseDao

@Dao
interface SakeAromaDao : BaseDao<SakeAroma> {
    @Query("SELECT * FROM sake_aromas WHERE id = :id LIMIT 1")
    suspend fun getSakeAromaById(id: Long): SakeAroma?

    @Query("SELECT * FROM sake_aromas WHERE sakeId = :sakeId")
    suspend fun getAromasForSake(sakeId: Long): List<SakeAroma>
}
