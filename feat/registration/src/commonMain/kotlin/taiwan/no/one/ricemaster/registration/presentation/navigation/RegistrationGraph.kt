package taiwan.no.one.ricemaster.registration.presentation.navigation

import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel
import taiwan.no.one.ricemaster.navigation.Graph.RegistrationGraph
import taiwan.no.one.ricemaster.registration.presentation.component.SignInRoute
import taiwan.no.one.ricemaster.registration.presentation.component.SignUpRoute
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.SignInViewModel

@Serializable
private data object SignInRoute

@Serializable
private data object SignUpRoute

fun NavGraphBuilder.RegistrationGraph() {
    navigation<RegistrationGraph>(startDestination = SignInRoute) {
        composable<SignInRoute> {
            val vm = koinViewModel<SignInViewModel>()
            val state = vm.state.collectAsStateWithLifecycle().value

            SignInRoute(
                modifier = Modifier,
                uiState = state,
                eventHandler = vm::handleEvent,
            )
        }

        composable<SignUpRoute> { SignUpRoute() }
    }
}
