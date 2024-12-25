package taiwan.no.one.ricemaster.state

import androidx.compose.runtime.Stable
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import taiwan.no.one.ricemaster.entity.TopLevelNavigationItem

@Stable
data class AppState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope,
) {
    val topLevelDestinationItems: List<TopLevelNavigationItem> = TopLevelNavigationItem.entries
}
