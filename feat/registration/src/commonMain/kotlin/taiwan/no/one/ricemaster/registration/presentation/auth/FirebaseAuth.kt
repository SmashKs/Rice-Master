package taiwan.no.one.ricemaster.registration.presentation.auth

import androidx.compose.runtime.Composable

interface FirebaseAuth {
    @Composable
    fun signInWithTwitter(
        onSuccess: (User) -> Unit,
        onError: (Exception) -> Unit,
    )

    fun createUser(
        email: String,
        password: String,
        onSuccess: (User) -> Unit,
        onError: (Exception) -> Unit,
    )

    fun signIn(
        email: String,
        password: String,
        onSuccess: (User) -> Unit,
        onError: (Exception) -> Unit,
    )
}
