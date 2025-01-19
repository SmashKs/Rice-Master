package taiwan.no.one.ricemaster.registration.domain.handler

import androidx.compose.runtime.Composable
import dev.gitlive.firebase.auth.AuthCredential

interface CredentialHandler {
    @Composable
    fun loginInWithFacebook(
        onSuccess: (String) -> Unit,
        onError: (Exception) -> Unit,
        onComplete: () -> Unit,
    )

    @Composable
    fun loginInWithTwitter(
        onSuccess: (AuthCredential) -> Unit,
        onError: (Exception) -> Unit,
        onComplete: () -> Unit,
    )

    @Composable
    fun loginInWithGoogle(
        onSuccess: (String) -> Unit,
        onError: (Exception) -> Unit,
        onComplete: () -> Unit,
    )
}
