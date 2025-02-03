package taiwan.no.one.ricemaster.registration.data.source

import kotlinx.coroutines.flow.Flow
import taiwan.no.one.ricemaster.registration.data.model.LoginModel
import taiwan.no.one.ricemaster.user.model.UserModel

interface RegistrationStore {
    fun fetchLoginDataFlow(): Flow<LoginModel>

    fun updateEmail(value: String)

    fun updatePassword(value: String)

    suspend fun createUser(email: String, password: String): Result<UserModel>

    suspend fun signIn(email: String, password: String): Result<UserModel>

    suspend fun signInWithGoogle(token: String): Result<UserModel>

    suspend fun signInWithFacebook(token: String): Result<UserModel>

    suspend fun logout(): Result<Unit>
}
