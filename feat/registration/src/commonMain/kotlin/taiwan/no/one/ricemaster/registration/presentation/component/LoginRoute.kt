package taiwan.no.one.ricemaster.registration.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.compose.koinInject
import taiwan.no.one.ricemaster.registration.data.auth.FirebaseAuth
import taiwan.no.one.ricemaster.registration.presentation.component.screen.LoginScreen
import taiwan.no.one.ricemaster.registration.presentation.entity.LoginUiState
import taiwan.no.one.ricemaster.registration.presentation.entity.LoginUiState.Twitter
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.LoginEvent

@Composable
internal fun LoginRoute(
    uiState: LoginUiState,
    modifier: Modifier = Modifier,
    eventHandler: (LoginEvent) -> Unit = {},
) {
    LoginScreen(
        modifier = modifier,
        uiState = uiState,
        eventHandler = eventHandler,
    )

    if (uiState is Twitter) {
        val firebaseAuth = koinInject<FirebaseAuth>()

        firebaseAuth.signInWithTwitter(
            onSuccess = {
                println("#################################################")
                println(it)
                println("#################################################")
            },
            onError = {
                println("=================================================")
                println(it)
                println("=================================================")
            },
            onComplete = { eventHandler.invoke(LoginEvent.DoneLoginMethod) },
        )
    }
}
