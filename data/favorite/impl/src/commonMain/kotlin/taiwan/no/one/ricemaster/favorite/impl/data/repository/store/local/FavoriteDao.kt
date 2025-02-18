package taiwan.no.one.ricemaster.favorite.impl.data.repository.store.local

import androidx.room.Dao
import androidx.room.Query
import taiwan.no.one.ricemaster.favorite.impl.data.model.FavoriteModel
import taiwan.no.one.ricemaster.persistence.data.BaseDao

@Dao
internal interface FavoriteDao : BaseDao<FavoriteModel> {
    @Query("SELECT user_id FROM favorite WHERE sake_id = :sakeId")
    suspend fun getLikesForSake(sakeId: String): List<String>

    @Query("SELECT sake_id FROM favorite WHERE user_id = :userId")
    suspend fun getLikesForUser(userId: String): List<String>

    @Query("SELECT EXISTS(SELECT 1 FROM favorite WHERE user_id = :userId AND sake_id = :sakeId)")
    suspend fun isSakeLikedByUser(userId: String, sakeId: String): Boolean
}
