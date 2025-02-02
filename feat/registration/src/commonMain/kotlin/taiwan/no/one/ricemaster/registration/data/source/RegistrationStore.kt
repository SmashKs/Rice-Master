package taiwan.no.one.ricemaster.registration.data.source

import kotlinx.coroutines.flow.Flow
import taiwan.no.one.ricemaster.registration.data.model.LoginModel

interface RegistrationStore {
    fun fetchLoginDataFlow(): Flow<LoginModel>

    fun updateEmail(value: String)

    fun updatePassword(value: String)

    suspend fun createUser(email: String, password: String): Result<Unit>

    suspend fun signIn(email: String, password: String): Result<Unit>

    suspend fun signInWithGoogle(token: String): Result<Unit>

    suspend fun signInWithFacebook(token: String): Result<Unit>

    suspend fun logout(): Result<Unit>
}
