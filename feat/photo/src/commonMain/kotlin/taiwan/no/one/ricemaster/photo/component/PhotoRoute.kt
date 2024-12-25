package taiwan.no.one.ricemaster.photo.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun PhotoRoute(
    modifier: Modifier = Modifier,
) {
    PhotoScreen(modifier = modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PhotoScreen(
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = "Photo")
        },
    )
}

@Preview
@Composable
private fun PreviewPhotoScreen() {
    MaterialTheme {
        PhotoScreen()
    }
}
