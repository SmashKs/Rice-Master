package taiwan.no.one.ricemaster.registration.presentation.handler

import androidx.compose.runtime.Composable
import androidx.compose.ui.interop.LocalUIViewController
import cocoapods.FirebaseAuth.FIRGoogleAuthProvider
import cocoapods.FirebaseCore.FIRApp
import cocoapods.GoogleSignIn.GIDConfiguration
import cocoapods.GoogleSignIn.GIDSignIn
import cocoapods.GoogleSignIn.GIDSignInResult
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.auth.ios
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
class GoogleSignIn : SignInHandler {
    @Composable
    override fun SignIn(
        onSuccess: () -> Unit,
        onError: (Exception) -> Unit,
        onComplete: () -> Unit,
    ) {
        val viewController = LocalUIViewController.current
        val googleSignIn = GIDSignIn.sharedInstance

        try {
            val clientId = FIRApp.defaultApp()
                ?.options
                ?.clientID
                ?: throw IllegalStateException("Client ID not found")
            googleSignIn.configuration = GIDConfiguration(clientID = clientId)

            googleSignIn.signInWithPresentingViewController(viewController) { result, error ->
                when {
                    error != null -> onError(Exception(error.toString()))
                    result != null -> handleGoogleSignInResult(result, onSuccess, onError)
                    else -> onError(NullPointerException("Sign-in result is null"))
                }
                onComplete()
            }
        } catch (e: Exception) {
            onError(e)
            onComplete()
        }
    }

    private fun handleGoogleSignInResult(
        result: GIDSignInResult,
        onSuccess: () -> Unit,
        onError: (Exception) -> Unit,
    ) {
        val idToken = result.user.idToken?.tokenString.orEmpty()
        val accessToken = result.user.accessToken.tokenString
        val credential = FIRGoogleAuthProvider.credentialWithIDToken(idToken, accessToken)

        Firebase.auth.ios.signInWithCredential(credential) { authResult, error ->
            when {
                error != null -> onError(Exception(error.toString()))
                authResult != null -> onSuccess()
                else -> onError(NullPointerException("Auth result is null"))
            }
        }
    }
}
