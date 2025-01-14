package taiwan.no.one.ricemaster.registration.data.model.mapper

import dev.gitlive.firebase.auth.FirebaseUser
import taiwan.no.one.ricemaster.user.model.UserModel

private fun FirebaseUser.convertToUser() = UserModel(
    idToken = uid,
    displayName = displayName.orEmpty(),
    profilePicUrl = photoURL,
)
