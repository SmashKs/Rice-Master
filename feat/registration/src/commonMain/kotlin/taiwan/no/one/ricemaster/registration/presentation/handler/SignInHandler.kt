package taiwan.no.one.ricemaster.registration.presentation.handler

import androidx.compose.runtime.Composable

interface SignInHandler {
    @Composable
    fun SignIn(
        onSuccess: () -> Unit,
        onError: (Exception) -> Unit,
        onComplete: () -> Unit,
    )
}
