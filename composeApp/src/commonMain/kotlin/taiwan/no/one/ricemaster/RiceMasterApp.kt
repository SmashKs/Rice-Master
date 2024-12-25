package taiwan.no.one.ricemaster

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import org.jetbrains.compose.ui.tooling.preview.Preview
import taiwan.no.one.ricemaster.component.BottomNavBarComponent
import taiwan.no.one.ricemaster.entity.TopLevelNavigationItem.EXPLORE
import taiwan.no.one.ricemaster.entity.TopLevelNavigationItem.FAVORITE
import taiwan.no.one.ricemaster.entity.TopLevelNavigationItem.IDENTITY
import taiwan.no.one.ricemaster.entity.TopLevelNavigationItem.PROFILE
import taiwan.no.one.ricemaster.favorite.navigation.FavoriteGraph
import taiwan.no.one.ricemaster.favorite.navigation.FavoriteGraphNavHost
import taiwan.no.one.ricemaster.favorite.navigation.navigateToFavorite
import taiwan.no.one.ricemaster.identity.navigation.IdentityGraph
import taiwan.no.one.ricemaster.identity.navigation.IdentityGraphNavHost
import taiwan.no.one.ricemaster.identity.navigation.navigateToIdentity
import taiwan.no.one.ricemaster.profile.navigation.ProfileGraph
import taiwan.no.one.ricemaster.profile.navigation.ProfileGraphNavHost
import taiwan.no.one.ricemaster.profile.navigation.navigateToProfile
import taiwan.no.one.ricemaster.search.navigation.SearchGraph
import taiwan.no.one.ricemaster.search.navigation.SearchGraphNavHost
import taiwan.no.one.ricemaster.search.navigation.navigateToSearch
import taiwan.no.one.ricemaster.state.AppState
import taiwan.no.one.ricemaster.state.currentTopLevelDestination
import taiwan.no.one.ricemaster.state.rememberAppState

@Composable
@Preview
fun RiceMasterApp(
    appState: AppState = rememberAppState(),
) {
    val rootNavController: NavHostController = appState.navController
    val currentTopLevelItem = appState.currentTopLevelDestination()

    MaterialTheme {
        Scaffold(
            topBar = {},
            bottomBar = {
                BottomNavBarComponent { topLevelItem ->
                    if (topLevelItem == currentTopLevelItem) {
                        // press the same button and do scroll up to the top, ...etc
                        return@BottomNavBarComponent
                    }
                    val topLevelNavOptions = navOptions {
                        // Pop up to the start destination of the graph to avoid building up a large
                        // stack of destinations on the back stack as users select items.
                        popUpTo(
                            rootNavController.graph.findStartDestination().id,
                        ) {
                            saveState = true
                        }

                        // Avoid multiple copies of the same destination when reselecting the same item.
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item.
                        restoreState = true
                    }

                    with(rootNavController) {
                        when (topLevelItem) {
                            EXPLORE -> navigateToSearch(topLevelNavOptions)
                            IDENTITY -> navigateToIdentity(topLevelNavOptions)
                            FAVORITE -> navigateToFavorite(topLevelNavOptions)
                            PROFILE -> navigateToProfile(topLevelNavOptions)
                        }
                    }
                }
            },
            content = { paddingValues ->
                NavHost(
                    modifier = Modifier.padding(paddingValues),
                    navController = rootNavController,
                    startDestination = SearchGraph,
                ) {
                    composable<SearchGraph> { SearchGraphNavHost() }
                    composable<IdentityGraph> { IdentityGraphNavHost() }
                    composable<FavoriteGraph> { FavoriteGraphNavHost() }
                    composable<ProfileGraph> { ProfileGraphNavHost() }
                }
            },
        )
    }
}
