package taiwan.no.one.ricemaster.user.model

data class UserModel(
    val idToken: String,
    val displayName: String = "",
    val profilePicUrl: String? = null,
)
