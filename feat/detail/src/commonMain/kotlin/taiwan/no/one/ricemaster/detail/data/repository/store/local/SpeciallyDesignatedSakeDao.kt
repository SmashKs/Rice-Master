package taiwan.no.one.ricemaster.detail.data.repository.store.local

import androidx.room.Dao
import androidx.room.Query
import taiwan.no.one.ricemaster.detail.data.model.SpeciallyDesignatedSake
import taiwan.no.one.ricemaster.persistence.data.BaseDao

@Dao
interface SpeciallyDesignatedSakeDao : BaseDao<SpeciallyDesignatedSake> {
    @Query("SELECT * FROM specially_designated_sake WHERE designatedSakeId = :designatedSakeId LIMIT 1")
    suspend fun getDesignatedSakeById(id: Long): SpeciallyDesignatedSake?

    @Query("SELECT * FROM specially_designated_sake")
    suspend fun getAllDesignatedSakes(): List<SpeciallyDesignatedSake>
}
