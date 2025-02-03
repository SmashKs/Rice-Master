package taiwan.no.one.ricemaster.registration.data.source.remote

import dev.gitlive.firebase.auth.FacebookAuthProvider
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.GoogleAuthProvider
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
    override fun fetchLoginDataFlow() = throw UnsupportedOperationException()

    override fun updateEmail(value: String) = throw UnsupportedOperationException()

    override fun updatePassword(value: String) = throw UnsupportedOperationException()

    override suspend fun createUser(email: String, password: String): Result<UserModel> {
        val authResult = firebaseAuth.createUserWithEmailAndPassword(email, password)
        return authResult.user?.run { Result.success(convertToUser()) } ?: Result.failure(IllegalStateException())
    }

    override suspend fun signIn(email: String, password: String): Result<UserModel> {
        val authResult = firebaseAuth.signInWithEmailAndPassword(email, password)
        return authResult.user?.run { Result.success(convertToUser()) } ?: Result.failure(IllegalStateException())
    }

    override suspend fun signInWithGoogle(token: String): Result<UserModel> =
        kotlin.runCatching { GoogleAuthProvider.credential(token, null) }
            .mapCatching { firebaseAuth.signInWithCredential(it).user ?: error("doesn't have an user info") }
            .mapCatching { it.convertToUser() }

    override suspend fun signInWithFacebook(token: String): Result<UserModel> =
        kotlin.runCatching { FacebookAuthProvider.credential(token) }
            .mapCatching { firebaseAuth.signInWithCredential(it).user ?: error("doesn't have an user info") }
            .mapCatching { it.convertToUser() }

    override suspend fun logout(): Result<Unit> = kotlin.runCatching { firebaseAuth.signOut() }
}
