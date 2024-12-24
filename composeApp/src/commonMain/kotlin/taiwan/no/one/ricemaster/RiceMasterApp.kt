package taiwan.no.one.ricemaster

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import org.jetbrains.compose.ui.tooling.preview.Preview
import taiwan.no.one.ricemaster.component.BottomNavBarComponent
import taiwan.no.one.ricemaster.search.navigation.SearchGraph
import taiwan.no.one.ricemaster.search.navigation.SearchGraphNavHost

@Composable
@Preview
fun RiceMasterApp(
    rootNavController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by rootNavController.currentBackStackEntryAsState()
    var showContent by remember { mutableStateOf(false) }

    MaterialTheme {
        Scaffold(
            topBar = {},
            bottomBar = {
                BottomNavBarComponent { topLevelItem ->
                    val topLevelNavOptions = navOptions {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(rootNavController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }

//                    when (topLevelItem) {
//                        EXPLORE -> rootNavController.navigateToSearch(topLevelNavOptions)
//                        CAMERA -> rootNavController.navigateToPhoto(topLevelNavOptions)
//                        FAVORITE -> rootNavController.navigateToFavorite(topLevelNavOptions)
//                        PROFILE -> rootNavController.navigateToProfile(topLevelNavOptions)
//                    }
                }
            },
            content = { paddingValues ->
                NavHost(
                    modifier = Modifier.padding(paddingValues),
                    navController = rootNavController,
                    startDestination = SearchGraph,
                ) {
                    composable<SearchGraph> { SearchGraphNavHost() }
                }
            },
        )
    }
}
