package taiwan.no.one.ricemaster.registration.presentation.auth

data class GoogleUser(
    val idToken: String,
    val displayName: String = "",
    val profilePicUrl: String? = null,
)
