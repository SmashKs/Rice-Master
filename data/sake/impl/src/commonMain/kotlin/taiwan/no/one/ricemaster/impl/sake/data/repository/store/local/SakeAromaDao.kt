package taiwan.no.one.ricemaster.impl.sake.data.repository.store.local

import androidx.room.Dao
import androidx.room.Query
import taiwan.no.one.ricemaster.impl.sake.data.model.compose.SakeAromaModel
import taiwan.no.one.ricemaster.persistence.data.BaseDao

@Dao
internal interface SakeAromaDao : BaseDao<SakeAromaModel> {
    @Query("SELECT * FROM sake_aromas WHERE id = :id LIMIT 1")
    suspend fun getSakeAromaById(id: Long): SakeAromaModel?

    @Query("SELECT * FROM sake_aromas WHERE sakeId = :sakeId")
    suspend fun getAromasForSake(sakeId: Long): List<SakeAromaModel>
}
