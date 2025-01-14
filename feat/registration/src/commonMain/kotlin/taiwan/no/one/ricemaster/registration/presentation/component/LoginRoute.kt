package taiwan.no.one.ricemaster.registration.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.compose.koinInject
import taiwan.no.one.ricemaster.registration.data.auth.FirebaseAuth
import taiwan.no.one.ricemaster.registration.domain.handler.CredentialHandler
import taiwan.no.one.ricemaster.registration.presentation.component.screen.LoginScreen
import taiwan.no.one.ricemaster.registration.presentation.entity.LoginUiState
import taiwan.no.one.ricemaster.registration.presentation.entity.LoginUiState.ThirdPartyMethod
import taiwan.no.one.ricemaster.registration.presentation.entity.LoginUiState.ThirdPartyMethod.Facebook
import taiwan.no.one.ricemaster.registration.presentation.entity.LoginUiState.ThirdPartyMethod.Google
import taiwan.no.one.ricemaster.registration.presentation.entity.LoginUiState.ThirdPartyMethod.Instagram
import taiwan.no.one.ricemaster.registration.presentation.entity.LoginUiState.ThirdPartyMethod.Twitter
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

    when (uiState as? ThirdPartyMethod ?: return) {
        is Google -> {
            val credentialHandler = koinInject<CredentialHandler>()

            credentialHandler.loginInWithGoogle(
                onSuccess = { eventHandler.invoke(LoginEvent.LoginWith(it)) },
                onError = {
                    println("#################################################")
                    println(it)
                    println("#################################################")
                },
                onComplete = { eventHandler.invoke(LoginEvent.DoneLoginMethod) },
            )
        }
        is Twitter -> {
//            val firebaseAuth = koinInject<FirebaseAuth>()
//
//            firebaseAuth.signInWithTwitter(
//                onSuccess = {
//                    println("#################################################")
//                    println(it)
//                    println("#################################################")
//                },
//                onError = {
//                    println("=================================================")
//                    println(it)
//                    println("=================================================")
//                },
//                onComplete = { eventHandler.invoke(LoginEvent.DoneLoginMethod) },
//            )
        }
        is Facebook -> {
            val credentialHandler = koinInject<CredentialHandler>()

            credentialHandler.loginInWithFacebook(
                onSuccess = {
                    println("=================================================")
                    println(it)
                    println("=================================================")
                    eventHandler.invoke(LoginEvent.LoginWith(it))
                },
                onError = {
                    println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$")
                    println(it)
                    println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$")
                },
                onComplete = { eventHandler.invoke(LoginEvent.DoneLoginMethod) },
            )
        }
        is Instagram -> {
            val firebaseAuth = koinInject<FirebaseAuth>()

            firebaseAuth.signInWithInstagram(
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
}
