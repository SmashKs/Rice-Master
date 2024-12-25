package taiwan.no.one.ricemaster.profile.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import taiwan.no.one.ricemaster.profile.component.ProfileRoute

@Serializable
data object ProfileGraph

@Serializable
private data object ProfileHome

fun NavController.navigateToProfile(navOptions: NavOptions) = navigate(ProfileGraph, navOptions)

@Composable
fun ProfileGraphNavHost(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = ProfileHome,
    ) {
        composable<ProfileHome> {
            ProfileRoute()
        }
    }
}
