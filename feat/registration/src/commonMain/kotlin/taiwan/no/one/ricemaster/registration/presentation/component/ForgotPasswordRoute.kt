package taiwan.no.one.ricemaster.registration.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import taiwan.no.one.ricemaster.registration.presentation.component.screen.ForgotPasswordScreen
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.forgot.ForgotPasswordEvent

@Composable
internal fun ForgotPasswordRoute(
//    state: SignUpUiState,
    modifier: Modifier = Modifier,
    eventHandler: (ForgotPasswordEvent) -> Unit = {},
) {
    ForgotPasswordScreen(
        modifier = modifier,
//        state = state,
        eventHandler = eventHandler,
    )
}
