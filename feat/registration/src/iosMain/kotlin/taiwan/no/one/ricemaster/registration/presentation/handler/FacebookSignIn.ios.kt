package taiwan.no.one.ricemaster.registration.presentation.handler

import androidx.compose.runtime.Composable

class FacebookSignIn : SignInHandler {
    @Composable
    override fun SignIn(
        onSuccess: () -> Unit,
        onError: (Exception) -> Unit,
        onComplete: () -> Unit,
    ) {
        println("=================================================")
        println("Facebook WIP")
        println("=================================================")
    }
}
