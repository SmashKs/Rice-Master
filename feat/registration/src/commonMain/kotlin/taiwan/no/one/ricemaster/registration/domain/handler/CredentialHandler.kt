package taiwan.no.one.ricemaster.registration.domain.handler

import androidx.compose.runtime.Composable

interface CredentialHandler {
    @Composable
    fun loginInWithFacebook(
        onSuccess: (String) -> Unit,
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
