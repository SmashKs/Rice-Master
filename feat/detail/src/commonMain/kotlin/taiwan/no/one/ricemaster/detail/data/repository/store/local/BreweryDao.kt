package taiwan.no.one.ricemaster.detail.data.repository.store.local

import androidx.room.Dao
import androidx.room.Query
import taiwan.no.one.ricemaster.detail.data.model.Brewery
import taiwan.no.one.ricemaster.persistence.data.BaseDao

@Dao
interface BreweryDao : BaseDao<Brewery> {
    @Query("SELECT * FROM breweries WHERE id = :id LIMIT 1")
    suspend fun getBreweryById(id: Long): Brewery?

    @Query("SELECT * FROM breweries")
    suspend fun getAllBreweries(): List<Brewery>
}
