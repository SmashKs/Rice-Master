package taiwan.no.one.ricemaster.registration.data.source

import taiwan.no.one.ricemaster.user.model.UserModel

interface RegistrationStore {
    suspend fun createUser(email: String, password: String): Result<UserModel>

    suspend fun signIn(email: String, password: String): Result<UserModel>

    suspend fun logout(): Result<Unit>
}
