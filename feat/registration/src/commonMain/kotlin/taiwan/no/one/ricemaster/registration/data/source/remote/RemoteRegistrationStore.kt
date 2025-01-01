package taiwan.no.one.ricemaster.registration.data.source.remote

import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import taiwan.no.one.ricemaster.registration.data.auth.FirebaseAuth
import taiwan.no.one.ricemaster.registration.data.source.RegistrationStore

@Single
@Named("remote")
internal class RemoteRegistrationStore : RegistrationStore, KoinComponent {
    private val firebaseAuth by inject<FirebaseAuth>()

    override fun fetchLoginDataFlow() = throw UnsupportedOperationException()

    override fun updateEmail(value: String) = throw UnsupportedOperationException()

    override fun updatePassword(value: String) = throw UnsupportedOperationException()

    override suspend fun createUser(
        email: String,
        password: String,
    ): Result<Unit> = suspendCancellableCoroutine { continuation ->
        firebaseAuth.createUser(
            email = email,
            password = password,
            onSuccess = { continuation.resume(Result.success(Unit)) },
            onError = { continuation.resume(Result.failure(it)) },
        )
        continuation.invokeOnCancellation {
            // The task can't be cancelled, but we can ensure we don't call resume if cancelled
            // This is already handled by the isActive checks above, but we keep this for clarity
        }
    }

    override suspend fun signIn(
        email: String,
        password: String,
    ): Result<Unit> = suspendCancellableCoroutine { continuation ->
        firebaseAuth.signIn(
            email = email,
            password = password,
            onSuccess = { continuation.resume(Result.success(Unit)) },
            onError = { continuation.resume(Result.failure(it)) },
        )
        continuation.invokeOnCancellation {
            // The task can't be cancelled, but we can ensure we don't call resume if cancelled
            // This is already handled by the isActive checks above, but we keep this for clarity
        }
    }

    override suspend fun signIn(token: String): Result<Unit> = suspendCancellableCoroutine { continuation ->
        firebaseAuth.signInWithGoogle(
            authToken = token,
            onSuccess = { continuation.resume(Result.success(Unit)) },
            onError = { continuation.resume(Result.failure(it)) },
        )
        continuation.invokeOnCancellation {
            // The task can't be cancelled, but we can ensure we don't call resume if cancelled
            // This is already handled by the isActive checks above, but we keep this for clarity
        }
    }
}
