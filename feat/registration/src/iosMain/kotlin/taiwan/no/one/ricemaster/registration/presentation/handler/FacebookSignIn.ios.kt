package taiwan.no.one.ricemaster.registration.presentation.handler

import androidx.compose.runtime.Composable
import androidx.compose.ui.interop.LocalUIViewController
import cocoapods.FBSDKLoginKit.FBSDKLoginManager
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FacebookAuthProvider
import dev.gitlive.firebase.auth.OAuthCredential
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.auth.ios
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
class FacebookSignIn : SignInHandler {
    @Composable
    override fun SignIn(
        onSuccess: (OAuthCredential) -> Unit,
        onError: (Exception) -> Unit,
        onComplete: () -> Unit,
    ) {
        val viewController = LocalUIViewController.current

        FBSDKLoginManager().logInWithPermissions(
            permissions = listOf("public_profile", "email"),
            fromViewController = viewController,
        ) { result, error ->
            when {
                error != null -> onError(Exception(error.toString()))
                result != null -> authenticateWithFirebase(
                    token = result.token?.tokenString()
                        ?: return@logInWithPermissions onError(NullPointerException("Facebook Sign-in result is null")),
                    onSuccess = onSuccess,
                    onError = onError,
                )
            }
        }
        onComplete()
    }

    private fun authenticateWithFirebase(
        token: String,
        onSuccess: (OAuthCredential) -> Unit,
        onError: (Exception) -> Unit,
    ) {
        val credential = FacebookAuthProvider.credential(token).ios
        Firebase.auth.ios.signInWithCredential(credential) { result, error ->
            when {
                error != null -> onError(Exception(error.toString()))
                result != null -> result.credential()
                    ?.let(::OAuthCredential)
                    ?.let(onSuccess)
                    ?: onError(Exception("Can't convert to OAuthCredential"))
                else -> onError(NullPointerException("Facebook sign-in failed"))
            }
        }
    }
}
