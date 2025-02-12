package taiwan.no.one.ricemaster.detail.data.repository.store.local

import androidx.room.Dao
import androidx.room.Query
import taiwan.no.one.ricemaster.detail.data.model.FlavorProfileModel
import taiwan.no.one.ricemaster.persistence.data.BaseDao

@Dao
interface FlavorProfileDao : BaseDao<FlavorProfileModel> {
    @Query("SELECT * FROM flavor_profiles WHERE id = :id LIMIT 1")
    suspend fun getFlavorProfileById(id: Long): FlavorProfileModel?

    @Query("SELECT * FROM flavor_profiles")
    suspend fun getAllFlavorProfiles(): List<FlavorProfileModel>
}
