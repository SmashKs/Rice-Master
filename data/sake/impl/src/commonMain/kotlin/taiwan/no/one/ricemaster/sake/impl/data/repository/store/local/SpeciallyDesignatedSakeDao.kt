package taiwan.no.one.ricemaster.sake.impl.data.repository.store.local

import androidx.room.Dao
import androidx.room.Query
import taiwan.no.one.ricemaster.persistence.data.BaseDao
import taiwan.no.one.ricemaster.sake.impl.data.model.SpeciallyDesignatedSakeModel

@Dao
internal interface SpeciallyDesignatedSakeDao : BaseDao<SpeciallyDesignatedSakeModel> {
    @Query("SELECT * FROM specially_designated_sake WHERE speciallyDesignatedSakeId = :id LIMIT 1")
    suspend fun getDesignatedSakeById(id: Long): SpeciallyDesignatedSakeModel?

    @Query("SELECT * FROM specially_designated_sake")
    suspend fun getAllDesignatedSakes(): List<SpeciallyDesignatedSakeModel>
}
