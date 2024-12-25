package taiwan.no.one.ricemaster.favorite.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import taiwan.no.one.ricemaster.favorite.component.FavoriteRoute

@Serializable
data object FavoriteGraph

@Serializable
private data object FavoriteHome

fun NavController.navigateToFavorite(navOptions: NavOptions) = navigate(FavoriteGraph, navOptions)

@Composable
fun FavoriteGraphNavHost(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = FavoriteHome,
    ) {
        composable<FavoriteHome> {
            FavoriteRoute()
        }
    }
}
