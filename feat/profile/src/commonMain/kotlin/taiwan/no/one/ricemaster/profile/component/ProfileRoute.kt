package taiwan.no.one.ricemaster.profile.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun ProfileRoute(
    modifier: Modifier = Modifier,
) {
    ProfileScreen(modifier = modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ProfileScreen(
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = "Profile")
        },
    )
}

@Preview
@Composable
private fun PreviewProfileScreen() {
    MaterialTheme {
        ProfileScreen()
    }
}
