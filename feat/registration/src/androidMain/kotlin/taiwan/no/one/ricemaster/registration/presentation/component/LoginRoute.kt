package taiwan.no.one.ricemaster.registration.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.serialization.Serializable
import taiwan.no.one.ricemaster.registration.presentation.component.screen.LoginScreen

@Serializable
data object LoginRoute

@Composable
internal fun LoginRoute(
    modifier: Modifier = Modifier,
) {
    LoginScreen(modifier = modifier)
}
