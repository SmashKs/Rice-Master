package taiwan.no.one.ricemaster.search.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import taiwan.no.one.ricemaster.search.component.SearchRoute

@Serializable
data object SearchGraph

@Serializable
private data object SearchHome

fun NavController.navigateToSearch(navOptions: NavOptions) = navigate(SearchGraph, navOptions)

@Composable
fun SearchGraphNavHost(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = SearchHome,
    ) {
        composable<SearchHome> {
            SearchRoute(modifier = Modifier)
        }
    }
}
