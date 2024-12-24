package taiwan.no.one.ricemaster.entity

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

internal enum class TopLevelNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
) {
    EXPLORE(
        title = "Explore",
        selectedIcon = Icons.Filled.Search,
        unselectedIcon = Icons.Outlined.Search,
    ),
    CAMERA(
        title = "Camera",
        selectedIcon = Icons.Filled.Call,
        unselectedIcon = Icons.Outlined.Call,
    ),
    FAVORITE(
        title = "Favorite",
        selectedIcon = Icons.Filled.Favorite,
        unselectedIcon = Icons.Outlined.Favorite,
    ),
    PROFILE(
        title = "Profile",
        selectedIcon = Icons.Filled.AccountCircle,
        unselectedIcon = Icons.Outlined.AccountCircle,
    ),
}
