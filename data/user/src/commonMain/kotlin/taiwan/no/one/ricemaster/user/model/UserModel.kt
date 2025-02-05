package taiwan.no.one.ricemaster.user.model

data class UserModel(
    val uid: String,
    val idToken: String,
    val displayName: String = "",
    val email: String = "",
    val profilePicUrl: String = "",
    val createdTime: Double = 0.0,
    val lastSignInTime: Double = 0.0,
)
