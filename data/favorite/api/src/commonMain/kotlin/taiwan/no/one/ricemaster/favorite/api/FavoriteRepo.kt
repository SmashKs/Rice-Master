package taiwan.no.one.ricemaster.favorite.api

interface FavoriteRepo {
    suspend fun getLikesForSake(sakeId: String): List<String>

    suspend fun getLikesForUser(userId: String): List<String>

    suspend fun addLike(userId: String, sakeId: String)

    suspend fun removeLike(userId: String, sakeId: String)

    suspend fun isSakeLikedByUser(userId: String, sakeId: String): Boolean
}
