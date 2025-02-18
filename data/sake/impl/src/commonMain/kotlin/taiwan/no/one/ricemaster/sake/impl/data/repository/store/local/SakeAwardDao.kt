package taiwan.no.one.ricemaster.sake.impl.data.repository.store.local

import androidx.room.Dao
import androidx.room.Query
import taiwan.no.one.ricemaster.persistence.data.BaseDao
import taiwan.no.one.ricemaster.sake.impl.data.model.AwardModel

@Dao
internal interface SakeAwardDao : BaseDao<AwardModel> {
    @Query("SELECT * FROM sake_awards WHERE awardId = :id LIMIT 1")
    suspend fun getSakeAwardById(id: Long): AwardModel?

    @Query("SELECT * FROM sake_awards")
    suspend fun getAllSakeAwards(): List<AwardModel>
}
