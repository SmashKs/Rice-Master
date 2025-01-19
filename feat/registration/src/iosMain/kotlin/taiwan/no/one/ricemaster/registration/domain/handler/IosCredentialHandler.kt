package taiwan.no.one.ricemaster.registration.domain.handler

import androidx.compose.runtime.Composable
import androidx.compose.ui.interop.LocalUIViewController
import cocoapods.FirebaseCore.FIRApp
import cocoapods.GoogleSignIn.GIDConfiguration
import cocoapods.GoogleSignIn.GIDSignIn
import dev.gitlive.firebase.auth.AuthCredential
import dev.gitlive.firebase.auth.OAuthProvider
import dev.gitlive.firebase.auth.ios
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
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
    override fun loginInWithTwitter(
        onSuccess: (AuthCredential) -> Unit,
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
                }
                credential?.let(::AuthCredential)
                    ?.let(onSuccess)
                    ?: onError(NullPointerException())
            },
        )
    }

    @Composable
    override fun loginInWithGoogle(
        onSuccess: (String) -> Unit,
        onError: (Exception) -> Unit,
        onComplete: () -> Unit,
    ) {
        val viewController = LocalUIViewController.current
        val googleGIDSignInMethod = GIDSignIn.sharedInstance

        kotlin.runCatching { requireNotNull(FIRApp.defaultApp()?.options?.clientID) }
            .mapCatching { clientId ->
                googleGIDSignInMethod.apply {
                    configuration = GIDConfiguration(clientID = clientId)
                }.signInWithPresentingViewController(
                    presentingViewController = viewController,
                    completion = { result, error ->
                        result?.user?.idToken?.tokenString?.run(onSuccess) ?: onError(Exception(error.toString()))
                    },
                )
            }
            .onFailure { onError(Exception(it)) }
    }
}
