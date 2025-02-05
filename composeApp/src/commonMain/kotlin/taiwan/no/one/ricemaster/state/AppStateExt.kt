package taiwan.no.one.ricemaster.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import taiwan.no.one.ricemaster.entity.TopLevelNavigationItem

@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
) = remember {
    AppState(
        navController = navController,
        coroutineScope = coroutineScope,
    )
}

@Composable
fun AppState.currentDestination(): NavDestination? = navController.currentBackStackEntryFlow
    .collectAsStateWithLifecycle(initialValue = null)
    .value
    ?.destination

@Composable
fun AppState.currentTopLevelDestination(): TopLevelNavigationItem? = TopLevelNavigationItem.entries.firstOrNull {
    currentDestination()?.hasRoute(it.route) == true
}
