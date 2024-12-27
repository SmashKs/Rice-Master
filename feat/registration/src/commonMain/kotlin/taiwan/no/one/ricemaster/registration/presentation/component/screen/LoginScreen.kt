package taiwan.no.one.ricemaster.registration.presentation.component.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.collections.immutable.toPersistentList
import org.jetbrains.compose.ui.tooling.preview.Preview
import taiwan.no.one.ricemaster.registration.presentation.component.section.ButtonSection
import taiwan.no.one.ricemaster.registration.presentation.component.section.Login3PartyIconsSection
import taiwan.no.one.ricemaster.registration.presentation.component.section.LoginFieldsSection
import taiwan.no.one.ricemaster.registration.presentation.entity.LoginUiState
import taiwan.no.one.ricemaster.registration.presentation.entity.SocialIcon
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.LoginEvent
import taiwan.no.one.ricemaster.ui.Sizing

@Composable
internal fun LoginScreen(
    uiState: LoginUiState,
    modifier: Modifier = Modifier,
    eventHandler: (LoginEvent) -> Unit = {},
) {
    Column(
        modifier = modifier.padding(horizontal = Sizing.spacing16),
    ) {
        LoginFieldsSection(
            modifier = Modifier,
            email = uiState.email,
            password = uiState.password,
            onEmailValChange = { eventHandler.invoke(LoginEvent.UpdateEmail(it)) },
            onPassValChange = { eventHandler.invoke(LoginEvent.UpdatePassword(it)) },
        )

        Login3PartyIconsSection(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            icons = SocialIcon.entries.toPersistentList(),
            onClick = { eventHandler.invoke(LoginEvent.Execute(it)) },
        )

        ButtonSection(
            modifier = Modifier,
            onLoginClick = { eventHandler.invoke(LoginEvent.Login) },
            onSignUpClick = { eventHandler.invoke(LoginEvent.SignUp) },
        )
    }
}

@Preview
@Composable
private fun PreviewLoginScreen() {
    MaterialTheme {
        LoginScreen(
            uiState = LoginUiState.Init(),
        )
    }
}
