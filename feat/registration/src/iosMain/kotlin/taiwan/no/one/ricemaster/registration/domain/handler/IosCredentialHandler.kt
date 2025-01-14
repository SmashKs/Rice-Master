package taiwan.no.one.ricemaster.registration.domain.handler

import androidx.compose.runtime.Composable
import androidx.compose.ui.interop.LocalUIViewController
import cocoapods.FirebaseCore.FIRApp
import cocoapods.GoogleSignIn.GIDConfiguration
import cocoapods.GoogleSignIn.GIDSignIn
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
internal class IosCredentialHandler(
    private val googleGIDSignInMethod: GIDSignIn,
) : CredentialHandler {
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
        val viewController = LocalUIViewController.current

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
            .onFailure { onError(it as Exception) }
    }
}
