package taiwan.no.one.ricemaster.detail.data.repository.store.local

import androidx.room.Dao
import androidx.room.Query
import taiwan.no.one.ricemaster.detail.data.model.Sake
import taiwan.no.one.ricemaster.persistence.data.BaseDao

@Dao
interface SakeDao : BaseDao<Sake> {
    @Query("SELECT * FROM sake WHERE id = :id LIMIT 1")
    suspend fun getSakeById(id: Long): Sake?

    @Query("SELECT * FROM sake")
    suspend fun getAllSakes(): List<Sake>
}
