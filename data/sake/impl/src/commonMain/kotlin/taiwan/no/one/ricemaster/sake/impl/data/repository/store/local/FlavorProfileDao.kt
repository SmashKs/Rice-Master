package taiwan.no.one.ricemaster.sake.impl.data.repository.store.local

import androidx.room.Dao
import androidx.room.Query
import taiwan.no.one.ricemaster.persistence.data.BaseDao
import taiwan.no.one.ricemaster.sake.impl.data.model.FlavorProfileModel

@Dao
internal interface FlavorProfileDao : BaseDao<FlavorProfileModel> {
    @Query("SELECT * FROM flavor_profiles WHERE flavorProfileId = :id LIMIT 1")
    suspend fun getFlavorProfileById(id: Long): FlavorProfileModel?

    @Query("SELECT * FROM flavor_profiles")
    suspend fun getAllFlavorProfiles(): List<FlavorProfileModel>
}
