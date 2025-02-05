package taiwan.no.one.ricemaster.registration.data.repository

import taiwan.no.one.ricemaster.user.model.UserModel

interface AuthRepo {
    suspend fun createUser(): Result<UserModel>

    suspend fun signIn(): Result<UserModel>

    suspend fun refreshToken(): Result<String>

    suspend fun logout(): Result<Unit>
}
