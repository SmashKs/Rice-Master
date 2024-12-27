package taiwan.no.one.ricemaster.registration.presentation.component.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import taiwan.no.one.ricemaster.ui.Sizing

@Composable
internal fun ButtonSection(
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {},
) {
    Column {
        Button(
            onClick = onLoginClick,
            content = {
                Text(text = "Login")
            },
        )

        Spacer(modifier = Modifier.size(size = Sizing.spacing8))

        Button(
            onClick = onSignUpClick,
            content = {
                Text(text = "Sign Up")
            },
        )
    }
}
