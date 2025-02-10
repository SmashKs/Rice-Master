package taiwan.no.one.ricemaster.profile.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import taiwan.no.one.ricemaster.profile.presentation.component.ProfileRoute

@Serializable
private data object ProfileRoute

@Composable
fun ProfileNavHost(
    modifier: Modifier = Modifier,
    subgraphBuilder: NavGraphBuilder.() -> Unit = {},
) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = ProfileRoute,
    ) {
        composable<ProfileRoute> {
            ProfileRoute(
                onNavigate = navController::navigate,
            )
        }

        subgraphBuilder.invoke(this)
    }
}
