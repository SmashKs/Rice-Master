package taiwan.no.one.ricemaster.identity.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import taiwan.no.one.ricemaster.identity.component.IdentityRoute

@Serializable
private data object IdentityRoute

@Composable
fun IdentityNavHost(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = IdentityRoute,
    ) {
        composable<IdentityRoute> {
            IdentityRoute()
        }
    }
}
