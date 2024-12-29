package taiwan.no.one.ricemaster.registration.presentation.auth

import androidx.compose.runtime.Composable
import taiwan.no.one.ricemaster.user.model.UserModel

interface FirebaseAuth {
    @Composable
    fun signInWithTwitter(
        onSuccess: (UserModel) -> Unit,
        onError: (Exception) -> Unit,
    )

    fun createUser(
        email: String,
        password: String,
        onSuccess: (UserModel) -> Unit,
        onError: (Exception) -> Unit,
    )

    fun signIn(
        email: String,
        password: String,
        onSuccess: (UserModel) -> Unit,
        onError: (Exception) -> Unit,
    )
}
