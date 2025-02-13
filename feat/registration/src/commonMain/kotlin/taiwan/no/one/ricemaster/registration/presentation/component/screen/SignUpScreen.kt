package taiwan.no.one.ricemaster.registration.presentation.component.screen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SignUpScreen(
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = "Sign Up")
        },
    )
}

@Preview
@Composable
private fun SignUpScreenPreview() {
    MaterialTheme {
        SignUpScreen()
    }
}
