package taiwan.no.one.ricemaster.user.model

data class UserModel(
    val uid: String,
    val idToken: String,
    val displayName: String = "",
    val email: String = "",
    val profilePicUrl: String? = null,
)
