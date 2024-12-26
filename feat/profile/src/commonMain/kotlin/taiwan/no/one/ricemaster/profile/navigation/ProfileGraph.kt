package taiwan.no.one.ricemaster.profile.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import taiwan.no.one.ricemaster.profile.component.ProfileRoute

@Serializable
private data object ProfileRoute

@Composable
fun ProfileNavHost(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = ProfileRoute,
    ) {
        composable<ProfileRoute> {
            ProfileRoute()
        }
    }
}
