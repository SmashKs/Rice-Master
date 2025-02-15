package taiwan.no.one.ricemaster.registration.presentation.navigation

import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel
import taiwan.no.one.ricemaster.navigation.Graph.RegistrationGraph
import taiwan.no.one.ricemaster.navigation.handler.handleNavigationEvents
import taiwan.no.one.ricemaster.registration.presentation.component.ForgotPasswordRoute
import taiwan.no.one.ricemaster.registration.presentation.component.SignInRoute
import taiwan.no.one.ricemaster.registration.presentation.component.SignUpRoute
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.forgot.ForgotPasswordViewModel
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.signin.SignInViewModel
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.signup.SignUpViewModel

@Serializable
internal data object SignInRoute

@Serializable
internal data object SignUpRoute

@Serializable
internal data object ForgotPasswordRoute

fun NavGraphBuilder.RegistrationGraph(
    navController: NavController,
) {
    navigation<RegistrationGraph>(startDestination = SignInRoute) {
        composable<SignInRoute> {
            val vm = koinViewModel<SignInViewModel>()
            val state = vm.state.collectAsStateWithLifecycle().value

            vm.navSharedFlow.handleNavigationEvents(navController)

            SignInRoute(
                modifier = Modifier,
                uiState = state,
                eventHandler = { vm.handleEvent(it) },
            )
        }

        composable<SignUpRoute> {
            val vm = koinViewModel<SignUpViewModel>()
            val state = vm.state.collectAsStateWithLifecycle().value

            vm.navSharedFlow.handleNavigationEvents(navController)

            SignUpRoute(
                modifier = Modifier,
                state = state,
                eventHandler = { vm.handleEvent(it) },
            )
        }

        composable<ForgotPasswordRoute> {
            val vm = koinViewModel<ForgotPasswordViewModel>()

            vm.navSharedFlow.handleNavigationEvents(navController)

            ForgotPasswordRoute(
                modifier = Modifier,
                eventHandler = {},
            )
        }
    }
}
