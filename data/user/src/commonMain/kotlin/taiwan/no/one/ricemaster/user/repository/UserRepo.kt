package taiwan.no.one.ricemaster.user.repository

import taiwan.no.one.ricemaster.user.model.UserModel

interface UserRepo {
    suspend fun getUserInfoModel(): Result<UserModel>

    suspend fun updateEmail(email: String): Result<Unit>

    suspend fun updatePassword(password: String): Result<Unit>

    suspend fun updateDisplayName(displayName: String): Result<Unit>

    suspend fun updatePhoto(url: String): Result<Unit>

    suspend fun delete(): Result<Unit>
}
