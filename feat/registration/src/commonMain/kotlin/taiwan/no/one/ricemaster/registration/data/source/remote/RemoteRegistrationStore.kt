package taiwan.no.one.ricemaster.registration.data.source.remote

import dev.gitlive.firebase.auth.AuthResult
import dev.gitlive.firebase.auth.FirebaseAuth
import kotlin.coroutines.cancellation.CancellationException
import org.koin.core.annotation.Named
import org.koin.core.annotation.Provided
import org.koin.core.annotation.Single
import taiwan.no.one.ricemaster.registration.data.model.mapper.convertToUser
import taiwan.no.one.ricemaster.registration.data.source.RegistrationStore
import taiwan.no.one.ricemaster.user.model.UserModel

@Single
@Named("remote")
internal class RemoteRegistrationStore(
    @Provided private val firebaseAuth: FirebaseAuth,
) : RegistrationStore {
    override suspend fun createUser(email: String, password: String): Result<UserModel> = kotlin.runCatching {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
    }.mapCatching { authResult -> toUserModel(authResult) }

    override suspend fun signIn(email: String, password: String): Result<UserModel> = kotlin.runCatching {
        firebaseAuth.signInWithEmailAndPassword(email, password)
    }.mapCatching { authResult -> toUserModel(authResult) }

    override suspend fun logout(): Result<Unit> = kotlin.runCatching { firebaseAuth.signOut() }

    @Throws(IllegalArgumentException::class, CancellationException::class)
    private suspend fun toUserModel(authResult: AuthResult) =
        authResult.user?.run { convertToUser() } ?: error("There is no user information")
}
