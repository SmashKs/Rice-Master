package taiwan.no.one.ricemaster.detail.data.repository.store.local

import androidx.room.Dao
import androidx.room.Query
import taiwan.no.one.ricemaster.detail.data.model.SpeciallyDesignatedSakeModel
import taiwan.no.one.ricemaster.persistence.data.BaseDao

@Dao
interface SpeciallyDesignatedSakeDao : BaseDao<SpeciallyDesignatedSakeModel> {
    @Query("SELECT * FROM specially_designated_sake WHERE id = :id LIMIT 1")
    suspend fun getDesignatedSakeById(id: Long): SpeciallyDesignatedSakeModel?

    @Query("SELECT * FROM specially_designated_sake")
    suspend fun getAllDesignatedSakes(): List<SpeciallyDesignatedSakeModel>
}
