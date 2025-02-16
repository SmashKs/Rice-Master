package taiwan.no.one.ricemaster.impl.sake.data.repository.store.local

import androidx.room.Dao
import androidx.room.Query
import taiwan.no.one.ricemaster.impl.sake.data.model.compose.SakeFlavorModel
import taiwan.no.one.ricemaster.persistence.data.BaseDao

@Dao
internal interface SakeFlavorDao : BaseDao<SakeFlavorModel> {
    @Query("SELECT * FROM sake_flavors WHERE id = :id LIMIT 1")
    suspend fun getSakeFlavorById(id: Long): SakeFlavorModel?

    @Query("SELECT * FROM sake_flavors WHERE sakeId = :sakeId")
    suspend fun getFlavorsForSake(sakeId: Long): List<SakeFlavorModel>
}
