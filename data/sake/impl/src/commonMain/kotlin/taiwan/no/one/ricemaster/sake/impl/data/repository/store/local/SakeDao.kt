package taiwan.no.one.ricemaster.sake.impl.data.repository.store.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import taiwan.no.one.ricemaster.persistence.data.BaseDao
import taiwan.no.one.ricemaster.sake.impl.data.model.SakeModel
import taiwan.no.one.ricemaster.sake.impl.data.model.compose.SakeDetailModel
import taiwan.no.one.ricemaster.sake.impl.data.model.relation.SakeAromaCrossRef
import taiwan.no.one.ricemaster.sake.impl.data.model.relation.SakeAwardCrossRef
import taiwan.no.one.ricemaster.sake.impl.data.model.relation.SakeFlavorCrossRef

@Dao
internal interface SakeDao : BaseDao<SakeModel> {
    @Query("SELECT * FROM sake WHERE sakeId = :id LIMIT 1")
    suspend fun getSakeById(id: Long): SakeModel?

    @Transaction
    @Query("SELECT * FROM sake WHERE sakeId = :sakeId")
    suspend fun getDetailedSake(sakeId: Long): SakeDetailModel

    @Query("SELECT * FROM sake")
    suspend fun getAllSakes(): List<SakeModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSakeAromaCrossRef(crossRef: SakeAromaCrossRef)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSakeAwardCrossRef(crossRef: SakeAwardCrossRef)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSakeFlavorCrossRef(crossRef: SakeFlavorCrossRef)
}
