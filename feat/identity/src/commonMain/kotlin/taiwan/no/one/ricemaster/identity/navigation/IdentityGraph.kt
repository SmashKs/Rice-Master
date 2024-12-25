package taiwan.no.one.ricemaster.identity.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import taiwan.no.one.ricemaster.identity.component.IdentityRoute

@Serializable
data object IdentityGraph

@Serializable
private data object IdentityHome

fun NavController.navigateToIdentity(navOptions: NavOptions) = navigate(IdentityGraph, navOptions)

@Composable
fun IdentityGraphNavHost(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = IdentityHome,
    ) {
        composable<IdentityHome> {
            IdentityRoute()
        }
    }
}
