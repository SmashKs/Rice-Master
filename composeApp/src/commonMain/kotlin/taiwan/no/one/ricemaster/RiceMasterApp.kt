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
import org.koin.compose.KoinContext
import taiwan.no.one.ricemaster.component.BottomNavBarComponent
import taiwan.no.one.ricemaster.entity.TopLevelNavigationItem.EXPLORE
import taiwan.no.one.ricemaster.entity.TopLevelNavigationItem.FAVORITE
import taiwan.no.one.ricemaster.entity.TopLevelNavigationItem.IDENTITY
import taiwan.no.one.ricemaster.entity.TopLevelNavigationItem.PROFILE
import taiwan.no.one.ricemaster.favorite.navigation.FavoriteNavHost
import taiwan.no.one.ricemaster.identity.navigation.IdentityNavHost
import taiwan.no.one.ricemaster.navigation.Graph.FavoriteTopGraph
import taiwan.no.one.ricemaster.navigation.Graph.IdentityTopGraph
import taiwan.no.one.ricemaster.navigation.Graph.ProfileTopGraph
import taiwan.no.one.ricemaster.navigation.Graph.SearchTopGraph
import taiwan.no.one.ricemaster.profile.presentation.navigation.ProfileNavHost
import taiwan.no.one.ricemaster.registration.presentation.navigation.RegistrationGraph
import taiwan.no.one.ricemaster.search.navigation.SearchNavHost
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

    KoinContext {
        MaterialTheme {
            Scaffold(
                topBar = {},
                bottomBar = {
                    BottomNavBarComponent(
                        onNavigateTopLevelScreen = { topLevelItem ->
//                            if (currentTopLevelItem == topLevelItem) {
//                                // press the same button and do scroll up to the top, ...etc
//                                // note: it crashes now if we access [currentTopLevelItem] with a null pointer
//                                return@BottomNavBarComponent
//                            }
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
                                    EXPLORE -> navigate(SearchTopGraph, topLevelNavOptions)
                                    IDENTITY -> navigate(IdentityTopGraph, topLevelNavOptions)
                                    FAVORITE -> navigate(FavoriteTopGraph, topLevelNavOptions)
                                    PROFILE -> navigate(ProfileTopGraph, topLevelNavOptions)
                                }
                            }
                        },
                    )
                },
                content = { paddingValues ->
                    NavHost(
                        modifier = Modifier.padding(paddingValues),
                        navController = rootNavController,
                        startDestination = SearchTopGraph,
                    ) {
                        composable<SearchTopGraph> { SearchNavHost() }

                        composable<IdentityTopGraph> { IdentityNavHost() }

                        composable<FavoriteTopGraph> { FavoriteNavHost() }

                        composable<ProfileTopGraph> {
                            ProfileNavHost(
                                subgraphBuilder = {
                                    RegistrationGraph()
                                },
                            )
                        }
                    }
                },
            )
        }
    }
}
