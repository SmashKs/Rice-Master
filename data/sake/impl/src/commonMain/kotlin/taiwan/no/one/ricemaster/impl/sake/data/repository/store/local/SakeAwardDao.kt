package taiwan.no.one.ricemaster.impl.sake.data.repository.store.local

import androidx.room.Dao
import androidx.room.Query
import taiwan.no.one.ricemaster.impl.sake.data.model.AwardModel
import taiwan.no.one.ricemaster.persistence.data.BaseDao

@Dao
internal interface SakeAwardDao : BaseDao<AwardModel> {
    @Query("SELECT * FROM sake_awards WHERE awardId = :id LIMIT 1")
    suspend fun getSakeAwardById(id: Long): AwardModel?

    @Query("SELECT * FROM sake_awards")
    suspend fun getAllSakeAwards(): List<AwardModel>
}
