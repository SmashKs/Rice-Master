package taiwan.no.one.ricemaster.favorite.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import taiwan.no.one.ricemaster.favorite.component.FavoriteRoute

@Serializable
private data object FavoriteRoute

@Composable
fun FavoriteNavHost(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = FavoriteRoute,
    ) {
        composable<FavoriteRoute> {
            FavoriteRoute()
        }
    }
}
