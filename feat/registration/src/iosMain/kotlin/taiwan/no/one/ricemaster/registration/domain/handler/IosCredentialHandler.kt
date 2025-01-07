package taiwan.no.one.ricemaster.registration.domain.handler

import androidx.compose.runtime.Composable

internal class IosCredentialHandler : CredentialHandler {
    @Composable
    override fun loginInWithFacebook(
        onSuccess: (String) -> Unit,
        onError: (Exception) -> Unit,
        onComplete: () -> Unit,
    ) {
        println("=================================================")
        println("facebook")
        println("=================================================")
    }

    @Composable
    override fun loginInWithGoogle(
        onSuccess: (String) -> Unit,
        onError: (Exception) -> Unit,
        onComplete: () -> Unit,
    ) {
        println("=================================================")
        println("Google")
        println("=================================================")
    }
}
