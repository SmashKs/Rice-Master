package taiwan.no.one.ricemaster.profile.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import taiwan.no.one.ricemaster.navigation.Graph
import taiwan.no.one.ricemaster.profile.component.screen.ProfileScreen

@Composable
internal fun ProfileRoute(
    modifier: Modifier = Modifier,
    onNavigate: (Graph) -> Unit = {},
) {
    ProfileScreen(
        modifier = modifier,
        onNavigate = onNavigate,
    )
}
