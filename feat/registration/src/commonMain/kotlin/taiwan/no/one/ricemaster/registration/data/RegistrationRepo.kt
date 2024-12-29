package taiwan.no.one.ricemaster.registration.data

import kotlinx.coroutines.flow.Flow
import taiwan.no.one.ricemaster.registration.data.model.LoginModel

interface RegistrationRepo {
    fun observeLoginFlow(): Flow<LoginModel>

    fun updateEmail(email: String)

    fun updatePassword(password: String)

    suspend fun createUser(): Result<Unit>

    suspend fun signIn(): Result<Unit>
}
