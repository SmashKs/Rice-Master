package taiwan.no.one.ricemaster.registration.data.model.mapper

import dev.gitlive.firebase.auth.FirebaseUser
import kotlin.coroutines.cancellation.CancellationException
import taiwan.no.one.ricemaster.user.model.UserModel

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
