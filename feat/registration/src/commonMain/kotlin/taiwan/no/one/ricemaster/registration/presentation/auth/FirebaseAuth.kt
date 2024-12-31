package taiwan.no.one.ricemaster.registration.presentation.auth

import androidx.compose.runtime.Composable
import androidx.core.bundle.Bundle
import taiwan.no.one.ricemaster.user.model.UserModel

interface FirebaseAuth {
    suspend fun signInWithGoogle(
        onSuccess: (String, Bundle) -> Unit,
        onError: (Exception) -> Unit,
    )

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
