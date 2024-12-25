package taiwan.no.one.ricemaster.identity.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun IdentityRoute(
    modifier: Modifier = Modifier,
) {
    IdentityScreen(modifier = modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun IdentityScreen(
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = "Identity")
        },
    )
}

@Preview
@Composable
private fun PreviewIdentityScreen() {
    MaterialTheme {
        IdentityScreen()
    }
}
