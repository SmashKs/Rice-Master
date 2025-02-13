package taiwan.no.one.ricemaster.registration.data.repository.impl

import dev.gitlive.firebase.auth.AuthResult
import dev.gitlive.firebase.auth.FirebaseAuth
import kotlin.coroutines.cancellation.CancellationException
import kotlinx.coroutines.flow.first
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Named
import org.koin.core.annotation.Provided
import taiwan.no.one.ricemaster.registration.data.model.mapper.convertToUser
import taiwan.no.one.ricemaster.registration.data.repository.AuthRepo
import taiwan.no.one.ricemaster.registration.data.source.UserFormStore
import taiwan.no.one.ricemaster.user.model.UserModel

@Factory
internal class AuthRepository(
    @Named("local") @Provided private val localUserFormStore: UserFormStore,
    @Provided private val firebaseAuth: FirebaseAuth,
) : AuthRepo {
    override suspend fun createUser(): Result<UserModel> =
        kotlin.runCatching { localUserFormStore.fetchSignInDataFlow().first() }
            .mapCatching { firebaseAuth.createUserWithEmailAndPassword(it.email, it.password) }
            .mapCatching { authResult -> toUserModel(authResult) }

    override suspend fun signIn(): Result<UserModel> =
        kotlin.runCatching { localUserFormStore.fetchSignInDataFlow().first() }
            .mapCatching { firebaseAuth.signInWithEmailAndPassword(it.email, it.password) }
            .mapCatching { authResult -> toUserModel(authResult) }

    override suspend fun refreshToken(): Result<String> = kotlin.runCatching {
        val user = requireNotNull(firebaseAuth.currentUser) { "Can't get user information" }
        requireNotNull(user.getIdToken(true)) { "Couldn't get/refresh the idToken" }
    }

    override suspend fun logout(): Result<Unit> = kotlin.runCatching { firebaseAuth.signOut() }

    @Throws(IllegalArgumentException::class, CancellationException::class)
    private suspend fun toUserModel(authResult: AuthResult) =
        authResult.user?.run { convertToUser() } ?: error("There is no user information")
}
