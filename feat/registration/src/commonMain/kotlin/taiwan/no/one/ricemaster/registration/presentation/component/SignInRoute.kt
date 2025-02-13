package taiwan.no.one.ricemaster.registration.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import taiwan.no.one.ricemaster.registration.presentation.component.screen.SignInScreen
import taiwan.no.one.ricemaster.registration.presentation.entity.SignInUiState
import taiwan.no.one.ricemaster.registration.presentation.entity.SignInUiState.ThirdPartyMethod
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.SignInEvent

@Composable
internal fun SignInRoute(
    uiState: SignInUiState,
    modifier: Modifier = Modifier,
    eventHandler: (SignInEvent) -> Unit = {},
) {
    SignInScreen(
        modifier = modifier,
        uiState = uiState,
        eventHandler = eventHandler,
    )

    (uiState as? ThirdPartyMethod)?.signInHandler?.SignIn(
        onSuccess = {
            println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓")
            println("success")
            println(it.providerId)
            println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑")
        },
        onError = ::println,
        onComplete = { eventHandler.invoke(SignInEvent.DoneLoginMethod) },
    )
}
