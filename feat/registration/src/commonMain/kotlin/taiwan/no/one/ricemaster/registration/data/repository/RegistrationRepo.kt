package taiwan.no.one.ricemaster.registration.data.repository

import taiwan.no.one.ricemaster.user.model.UserModel

interface RegistrationRepo {
    suspend fun createUser(): Result<UserModel>

    suspend fun signIn(): Result<UserModel>
}
