package taiwan.no.one.ricemaster.impl.sake.data.repository.store.local

import androidx.room.Dao
import androidx.room.Query
import taiwan.no.one.ricemaster.impl.sake.data.model.SakeModel
import taiwan.no.one.ricemaster.persistence.data.BaseDao

@Dao
internal interface SakeDao : BaseDao<SakeModel> {
    @Query("SELECT * FROM sake WHERE id = :id LIMIT 1")
    suspend fun getSakeById(id: Long): SakeModel?

    @Query("SELECT * FROM sake")
    suspend fun getAllSakes(): List<SakeModel>
}
