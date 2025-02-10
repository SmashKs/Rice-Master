package taiwan.no.one.ricemaster.profile.data.model.mapper

import dev.gitlive.firebase.auth.FirebaseUser
import kotlin.coroutines.cancellation.CancellationException
import taiwan.no.one.ricemaster.user.model.UserModel

/**
 * Converts a FirebaseUser object to a UserModel object.
 *
 * This function maps the FirebaseUser properties to the corresponding UserModel properties. It ensures that ID token is
 * retrieved and non-null, and provides default values for optional fields.
 *
 * They are the same, please don't forget modifying both places
 * [taiwan.no.one.ricemaster.registration.data.model.mapper.convertToUser]
 *
 * @return UserModel object containing user data.
 * @throws IllegalArgumentException if any required field is invalid.
 * @throws CancellationException if the coroutine is cancelled during execution.
 */
@Throws(IllegalArgumentException::class, CancellationException::class)
internal suspend fun FirebaseUser.convertToUser() = UserModel(
    uid = uid,
    idToken = requireNotNull(getIdToken(false)),
    displayName = displayName.orEmpty(),
    email = email.orEmpty(),
    profilePicUrl = photoURL.orEmpty(),
    createdTime = metaData?.creationTime ?: 0.0,
    lastSignInTime = metaData?.lastSignInTime ?: 0.0,
)
