package taiwan.no.one.ricemaster.registration.data.repository

import kotlinx.coroutines.flow.Flow
import taiwan.no.one.ricemaster.registration.data.model.LoginMethodModel
import taiwan.no.one.ricemaster.registration.data.model.LoginModel
import taiwan.no.one.ricemaster.user.model.UserModel

interface RegistrationRepo {
    fun observeLoginFlow(): Flow<LoginModel>

    fun updateEmail(email: String)

    fun updatePassword(password: String)

    suspend fun createUser(): Result<UserModel>

    suspend fun signIn(): Result<UserModel>

    suspend fun signIn(method: LoginMethodModel): Result<UserModel>
}
