package taiwan.no.one.ricemaster.registration.data.repository.impl

import dev.gitlive.firebase.auth.FirebaseAuth
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Provided
import taiwan.no.one.ricemaster.registration.data.model.mapper.convertToUser
import taiwan.no.one.ricemaster.user.model.UserModel
import taiwan.no.one.ricemaster.user.repository.UserRepo

@Factory
internal class UserRepository(
    @Provided private val firebaseAuth: FirebaseAuth,
) : UserRepo {
    private val currentUser get() = requireNotNull(firebaseAuth.currentUser)

    override suspend fun getUserInfoModel(): Result<UserModel> = kotlin.runCatching { currentUser.convertToUser() }

    override suspend fun updateEmail(email: String): Result<Unit> = kotlin.runCatching {
        currentUser.verifyBeforeUpdateEmail(newEmail = email)
    }

    override suspend fun updatePassword(password: String): Result<Unit> = kotlin.runCatching {
        currentUser.updatePassword(password = password)
    }

    override suspend fun updateDisplayName(displayName: String): Result<Unit> = kotlin.runCatching {
        currentUser.updateProfile(displayName = displayName)
    }

    override suspend fun updatePhoto(url: String): Result<Unit> = kotlin.runCatching {
        currentUser.updateProfile(photoUrl = url)
    }

    override suspend fun delete(): Result<Unit> = kotlin.runCatching { currentUser.delete() }
}
