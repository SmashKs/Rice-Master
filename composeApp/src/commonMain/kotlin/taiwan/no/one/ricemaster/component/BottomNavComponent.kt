package taiwan.no.one.ricemaster.component

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import taiwan.no.one.ricemaster.entity.TopLevelNavigationItem

@Composable
internal fun BottomNavBarComponent(
    modifier: Modifier = Modifier,
    onNavigateTopLevelScreen: (TopLevelNavigationItem) -> Unit = {},
) {
    var selectedItem by remember { mutableStateOf(TopLevelNavigationItem.EXPLORE) }

    BottomAppBar(
        modifier = modifier,
    ) {
        TopLevelNavigationItem.entries.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == item,
                onClick = {
                    selectedItem = item
                    onNavigateTopLevelScreen(item)
                },
                icon = {
                    Icon(
                        imageVector = if (item == selectedItem) item.selectedIcon else item.unselectedIcon,
                        contentDescription = null,
                    )
                },
            )
        }
    }
}

@Preview
@Composable
private fun PreviewBottomNavBarComponent() {
    MaterialTheme {
        BottomNavBarComponent()
    }
}
