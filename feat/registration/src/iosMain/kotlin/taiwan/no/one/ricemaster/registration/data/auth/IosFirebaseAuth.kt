package taiwan.no.one.ricemaster.registration.data.auth

import androidx.compose.runtime.Composable
import taiwan.no.one.ricemaster.user.model.UserModel

internal class IosFirebaseAuth : FirebaseAuth {
    @Composable
    override fun signInWithInstagram(
        onSuccess: (UserModel) -> Unit,
        onError: (Exception) -> Unit,
        onComplete: () -> Unit,
    ) {
    }

    @Composable
    override fun signInWithTwitter(
        onSuccess: (UserModel) -> Unit,
        onError: (Exception) -> Unit,
        onComplete: () -> Unit,
    ) {
    }

    override fun signInWithFacebook(
        authToken: String,
        onSuccess: (UserModel) -> Unit,
        onError: (Exception) -> Unit,
    ) {
    }

    override fun signInWithGoogle(
        authToken: String,
        onSuccess: (UserModel) -> Unit,
        onError: (Exception) -> Unit,
    ) {
    }

    override fun createUser(
        email: String,
        password: String,
        onSuccess: (UserModel) -> Unit,
        onError: (Exception) -> Unit,
    ) {
    }

    override fun signIn(
        email: String,
        password: String,
        onSuccess: (UserModel) -> Unit,
        onError: (Exception) -> Unit,
    ) {
    }
}
