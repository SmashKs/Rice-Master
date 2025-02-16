package taiwan.no.one.ricemaster.impl.sake.data.repository.store.local

import androidx.room.Dao
import androidx.room.Query
import taiwan.no.one.ricemaster.impl.sake.data.model.FlavorProfileModel
import taiwan.no.one.ricemaster.persistence.data.BaseDao

@Dao
internal interface FlavorProfileDao : BaseDao<FlavorProfileModel> {
    @Query("SELECT * FROM flavor_profiles WHERE flavorProfileId = :id LIMIT 1")
    suspend fun getFlavorProfileById(id: Long): FlavorProfileModel?

    @Query("SELECT * FROM flavor_profiles")
    suspend fun getAllFlavorProfiles(): List<FlavorProfileModel>
}
