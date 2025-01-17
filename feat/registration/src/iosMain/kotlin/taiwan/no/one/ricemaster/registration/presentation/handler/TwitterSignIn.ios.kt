package taiwan.no.one.ricemaster.registration.presentation.handler

import androidx.compose.runtime.Composable
import dev.gitlive.firebase.auth.AuthCredential
import dev.gitlive.firebase.auth.OAuthProvider
import dev.gitlive.firebase.auth.ios
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
class TwitterSignIn : SignInHandler {
    @Composable
    override fun SignIn(
        onSuccess: () -> Unit,
        onError: (Exception) -> Unit,
        onComplete: () -> Unit,
    ) {
        val provider = OAuthProvider("twitter.com").ios.apply {
            setCustomParameters(mapOf("lang" to "en"))
        }

        provider.getCredentialWithUIDelegate(
            uiDelegate = null,
            completion = { credential, error ->
                if (error != null) {
                    onError(Exception(error.toString()))
                } else {
                    credential?.let(::AuthCredential)
                        ?.let { onSuccess() }
                        ?: onError(NullPointerException())
                }
            },
        )
    }
}
