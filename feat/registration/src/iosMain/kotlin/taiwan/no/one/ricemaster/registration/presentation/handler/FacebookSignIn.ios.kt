package taiwan.no.one.ricemaster.registration.presentation.handler

import androidx.compose.runtime.Composable
import androidx.compose.ui.interop.LocalUIViewController
import cocoapods.FBSDKLoginKit.FBSDKLoginManager
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
class FacebookSignIn : SignInHandler {
    @Composable
    override fun SignIn(
        onSuccess: () -> Unit,
        onError: (Exception) -> Unit,
        onComplete: () -> Unit,
    ) {
        val viewController = LocalUIViewController.current
        FBSDKLoginManager().logInWithPermissions(
            permissions = listOf("public_profile", "email"),
            fromViewController = viewController,
            handler = { result, error ->
                println("=================================================")
                println(result)
                println("=================================================")
            },
        )
    }
}
