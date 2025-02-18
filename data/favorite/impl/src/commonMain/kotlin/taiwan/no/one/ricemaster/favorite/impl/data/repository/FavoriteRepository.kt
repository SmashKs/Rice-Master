package taiwan.no.one.ricemaster.favorite.impl.data.repository

import org.koin.core.annotation.Factory
import org.koin.core.annotation.Provided
import taiwan.no.one.ricemaster.favorite.api.FavoriteRepo
import taiwan.no.one.ricemaster.favorite.impl.data.FavoriteDatabase
import taiwan.no.one.ricemaster.favorite.impl.data.model.FavoriteModel

@Factory
internal class FavoriteRepository(
    @Provided private val database: FavoriteDatabase,
) : FavoriteRepo {
    override suspend fun getLikesForSake(sakeId: String): List<String> = database.favoriteDao().getLikesForSake(sakeId)

    override suspend fun getLikesForUser(userId: String): List<String> = database.favoriteDao().getLikesForUser(userId)

    override suspend fun addLike(userId: String, sakeId: String) {
        database.favoriteDao().insert(FavoriteModel(userId = userId, sakeId = sakeId))
    }

    override suspend fun removeLike(userId: String, sakeId: String) {
        database.favoriteDao().delete(FavoriteModel(userId = userId, sakeId = sakeId))
    }

    override suspend fun isSakeLikedByUser(userId: String, sakeId: String): Boolean =
        database.favoriteDao().isSakeLikedByUser(userId = userId, sakeId = sakeId)
}
