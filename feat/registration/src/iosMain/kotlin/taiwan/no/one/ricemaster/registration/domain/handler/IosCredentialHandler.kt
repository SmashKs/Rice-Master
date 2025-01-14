package taiwan.no.one.ricemaster.registration.domain.handler

import androidx.compose.runtime.Composable
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.auth.ios
import kotlinx.cinterop.ExperimentalForeignApi

internal class IosCredentialHandler : CredentialHandler {
    @OptIn(ExperimentalForeignApi::class)
    @Composable
    override fun loginInWithFacebook(
        onSuccess: (String) -> Unit,
        onError: (Exception) -> Unit,
        onComplete: () -> Unit,
    ) {
        println("=================================================")
        println("facebook ${Firebase.auth.ios}")
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
