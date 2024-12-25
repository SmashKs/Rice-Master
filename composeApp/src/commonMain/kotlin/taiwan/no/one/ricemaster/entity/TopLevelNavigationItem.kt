package taiwan.no.one.ricemaster.entity

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector
import taiwan.no.one.ricemaster.favorite.navigation.FavoriteGraph
import taiwan.no.one.ricemaster.identity.navigation.IdentityGraph
import taiwan.no.one.ricemaster.profile.navigation.ProfileGraph
import taiwan.no.one.ricemaster.search.navigation.SearchGraph
import kotlin.reflect.KClass

enum class TopLevelNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: KClass<*>,
) {
    EXPLORE(
        title = "Explore",
        selectedIcon = Icons.Filled.Search,
        unselectedIcon = Icons.Outlined.Search,
        route = SearchGraph::class,
    ),
    IDENTITY(
        title = "Identity",
        selectedIcon = Icons.Filled.Face,
        unselectedIcon = Icons.Outlined.Face,
        route = IdentityGraph::class,
    ),
    FAVORITE(
        title = "Favorite",
        selectedIcon = Icons.Filled.Favorite,
        unselectedIcon = Icons.Filled.FavoriteBorder,
        route = FavoriteGraph::class,
    ),
    PROFILE(
        title = "Profile",
        selectedIcon = Icons.Filled.AccountCircle,
        unselectedIcon = Icons.Outlined.AccountCircle,
        route = ProfileGraph::class,
    ),
}
