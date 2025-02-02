package taiwan.no.one.ricemaster.profile.component.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import taiwan.no.one.ricemaster.navigation.Graph
import taiwan.no.one.ricemaster.navigation.Graph.RegistrationGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ProfileScreen(
    modifier: Modifier = Modifier,
    onNavigate: (Graph) -> Unit = {},
) {
    Column(
        modifier = modifier,
    ) {
        TopAppBar(
            title = {
                Text(text = "Profile")
            },
        )

        Row {
            Button(
                modifier = Modifier,
                onClick = { onNavigate(RegistrationGraph) },
                content = {
                    Text(
                        text = "Join us!",
                    )
                },
            )
        }
    }
}

@Preview
@Composable
private fun PreviewProfileScreen() {
    MaterialTheme {
        ProfileScreen()
    }
}
