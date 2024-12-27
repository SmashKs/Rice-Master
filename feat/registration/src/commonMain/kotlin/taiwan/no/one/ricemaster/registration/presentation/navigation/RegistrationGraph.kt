package taiwan.no.one.ricemaster.registration.presentation.navigation

import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinNavViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import taiwan.no.one.ricemaster.navigation.Graph.RegistrationGraph
import taiwan.no.one.ricemaster.registration.presentation.component.LoginRoute
import taiwan.no.one.ricemaster.registration.presentation.component.SignInRoute
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.LoginViewModel

@Serializable
private data object LoginRoute

@Serializable
private data object SignInRoute

@OptIn(KoinExperimentalAPI::class)
fun NavGraphBuilder.RegistrationGraph() {
    navigation<RegistrationGraph>(startDestination = LoginRoute) {
        composable<LoginRoute> {
            val vm = koinNavViewModel<LoginViewModel>()
            val state = vm.state.collectAsStateWithLifecycle().value

            LoginRoute(
                modifier = Modifier,
                uiState = state,
                eventHandler = vm::handleEvent,
            )
        }

        composable<SignInRoute> { SignInRoute() }
    }
}
