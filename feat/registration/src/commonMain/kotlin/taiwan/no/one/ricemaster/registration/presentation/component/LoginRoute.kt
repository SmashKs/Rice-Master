package taiwan.no.one.ricemaster.registration.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import taiwan.no.one.ricemaster.registration.presentation.component.screen.LoginScreen
import taiwan.no.one.ricemaster.registration.presentation.entity.LoginUiState
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.LoginEvent

@Composable
internal fun LoginRoute(
    uiState: LoginUiState,
    modifier: Modifier = Modifier,
    eventHandler: (LoginEvent) -> Unit = {},
) {
    LoginScreen(
        modifier = modifier,
        uiState = uiState,
        eventHandler = eventHandler,
    )
}
