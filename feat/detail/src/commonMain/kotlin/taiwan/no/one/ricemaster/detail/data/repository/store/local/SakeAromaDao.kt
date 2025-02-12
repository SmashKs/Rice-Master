package taiwan.no.one.ricemaster.detail.data.repository.store.local

import androidx.room.Dao
import androidx.room.Query
import taiwan.no.one.ricemaster.detail.data.model.compose.SakeAromaModel
import taiwan.no.one.ricemaster.persistence.data.BaseDao

@Dao
interface SakeAromaDao : BaseDao<SakeAromaModel> {
    @Query("SELECT * FROM sake_aromas WHERE id = :id LIMIT 1")
    suspend fun getSakeAromaById(id: Long): SakeAromaModel?

    @Query("SELECT * FROM sake_aromas WHERE sakeId = :sakeId")
    suspend fun getAromasForSake(sakeId: Long): List<SakeAromaModel>
}
