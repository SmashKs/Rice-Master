package taiwan.no.one.ricemaster.registration.data.repository

import dev.gitlive.firebase.auth.FirebaseAuth
import kotlin.coroutines.cancellation.CancellationException
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Provided
import taiwan.no.one.ricemaster.registration.data.model.mapper.convertToUser
import taiwan.no.one.ricemaster.user.model.UserModel
import taiwan.no.one.ricemaster.user.repository.UserRepo

@Factory
internal class UserRepository(
    @Provided private val firebaseAuth: FirebaseAuth,
) : UserRepo {
    @Throws(NullPointerException::class, IllegalArgumentException::class, CancellationException::class)
    override suspend fun getUserInfoModel(): UserModel =
        firebaseAuth.currentUser?.convertToUser() ?: throw NullPointerException()
}
