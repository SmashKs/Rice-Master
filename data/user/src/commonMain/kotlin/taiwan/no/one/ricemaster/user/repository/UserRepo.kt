package taiwan.no.one.ricemaster.user.repository

import kotlin.coroutines.cancellation.CancellationException
import taiwan.no.one.ricemaster.user.model.UserModel

interface UserRepo {
    @Throws(NullPointerException::class, IllegalArgumentException::class, CancellationException::class)
    suspend fun getUserInfoModel(): UserModel
}
