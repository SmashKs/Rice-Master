package taiwan.no.one.ricemaster.detail.data.repository.store.local

import androidx.room.Dao
import androidx.room.Query
import taiwan.no.one.ricemaster.detail.data.model.compose.SakeFlavor
import taiwan.no.one.ricemaster.persistence.data.BaseDao

@Dao
interface SakeFlavorDao : BaseDao<SakeFlavor> {
    @Query("SELECT * FROM sake_flavors WHERE id = :id LIMIT 1")
    suspend fun getSakeFlavorById(id: Long): SakeFlavor?

    @Query("SELECT * FROM sake_flavors WHERE sakeId = :sakeId")
    suspend fun getFlavorsForSake(sakeId: Long): List<SakeFlavor>
}
