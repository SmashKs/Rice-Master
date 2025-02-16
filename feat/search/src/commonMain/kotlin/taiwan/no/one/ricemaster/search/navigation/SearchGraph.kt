package taiwan.no.one.ricemaster.search.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel
import taiwan.no.one.ricemaster.search.component.SearchRoute
import taiwan.no.one.ricemaster.search.presentation.viewmodel.SearchViewModel

@Serializable
private data object SearchRoute

@Composable
fun SearchNavHost(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = SearchRoute,
    ) {
        composable<SearchRoute> {
            val vm = koinViewModel<SearchViewModel>()

            SearchRoute(modifier = Modifier)
        }
    }
}
