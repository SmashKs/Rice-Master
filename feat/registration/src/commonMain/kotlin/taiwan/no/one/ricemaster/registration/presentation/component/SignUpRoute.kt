package taiwan.no.one.ricemaster.registration.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import taiwan.no.one.ricemaster.registration.presentation.component.screen.SignUpScreen
import taiwan.no.one.ricemaster.registration.presentation.entity.SignUpUiState
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.signup.SignUpEvent

@Composable
internal fun SignUpRoute(
    state: SignUpUiState,
    modifier: Modifier = Modifier,
    eventHandler: (SignUpEvent) -> Unit = {},
) {
    SignUpScreen(
        modifier = modifier,
        state = state,
        eventHandler = eventHandler,
    )
}
