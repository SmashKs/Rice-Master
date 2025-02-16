package taiwan.no.one.ricemaster.impl.sake.data.repository.store.local

import androidx.room.Dao
import androidx.room.Query
import taiwan.no.one.ricemaster.impl.sake.data.model.BreweryModel
import taiwan.no.one.ricemaster.persistence.data.BaseDao

@Dao
internal interface BreweryDao : BaseDao<BreweryModel> {
    @Query("SELECT * FROM breweries WHERE breweryId = :id LIMIT 1")
    suspend fun getBreweryById(id: Long): BreweryModel?

    @Query("SELECT * FROM breweries")
    suspend fun getAllBreweries(): List<BreweryModel>
}
