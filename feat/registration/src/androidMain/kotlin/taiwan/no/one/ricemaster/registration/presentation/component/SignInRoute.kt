package taiwan.no.one.ricemaster.registration.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.serialization.Serializable
import taiwan.no.one.ricemaster.registration.presentation.component.screen.SignInScreen

@Serializable
data object SignInRoute

@Composable
internal fun SignInRoute(
    modifier: Modifier = Modifier,
) {
    SignInScreen(modifier = modifier)
}
