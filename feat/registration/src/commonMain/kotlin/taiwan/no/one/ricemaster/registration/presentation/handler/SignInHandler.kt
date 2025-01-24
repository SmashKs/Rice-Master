package taiwan.no.one.ricemaster.registration.presentation.handler

import androidx.compose.runtime.Composable
import dev.gitlive.firebase.auth.OAuthCredential

interface SignInHandler {
    @Composable
    fun SignIn(
        onSuccess: (OAuthCredential) -> Unit,
        onError: (Exception) -> Unit,
        onComplete: () -> Unit,
    )
}
