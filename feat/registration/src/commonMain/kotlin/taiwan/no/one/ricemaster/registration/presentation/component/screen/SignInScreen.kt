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
import taiwan.no.one.ricemaster.registration.presentation.component.section.SignInFieldsSection
import taiwan.no.one.ricemaster.registration.presentation.entity.SignInUiState
import taiwan.no.one.ricemaster.registration.presentation.entity.SocialIcon
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.signin.SignInEvent
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.signin.SignInEvent.SignIn
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.signin.SignInEvent.SignUp
import taiwan.no.one.ricemaster.ui.Sizing

@Composable
internal fun SignInScreen(
    uiState: SignInUiState,
    modifier: Modifier = Modifier,
    eventHandler: (SignInEvent) -> Unit = {},
) {
    Column(
        modifier = modifier.padding(horizontal = Sizing.spacing16),
    ) {
        SignInFieldsSection(
            modifier = Modifier,
            email = uiState.email,
            password = uiState.password,
            onEmailValChange = { eventHandler.invoke(SignInEvent.UpdateEmail(it)) },
            onPassValChange = { eventHandler.invoke(SignInEvent.UpdatePassword(it)) },
        )

        ButtonSection(
            modifier = Modifier,
            onSignInClick = { eventHandler.invoke(SignIn) },
            onSignUpClick = { eventHandler.invoke(SignUp) },
        )

        Login3PartyIconsSection(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            icons = SocialIcon.entries.toPersistentList(),
            onClick = { eventHandler.invoke(SignInEvent.Execute(it)) },
        )
    }
}

@Preview
@Composable
private fun SignInScreenPreview() {
    MaterialTheme {
        SignInScreen(
            uiState = SignInUiState.Init,
        )
    }
}
