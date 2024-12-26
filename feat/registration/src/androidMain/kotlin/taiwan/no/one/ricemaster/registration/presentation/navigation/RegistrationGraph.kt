package taiwan.no.one.ricemaster.registration.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import taiwan.no.one.ricemaster.navigation.Graph.RegistrationGraph
import taiwan.no.one.ricemaster.registration.presentation.component.LoginRoute
import taiwan.no.one.ricemaster.registration.presentation.component.SignInRoute

@Serializable
private data object LoginRoute

@Serializable
private data object SignInRoute

@Composable
fun NavGraphBuilder.RegistrationGraph() {
    navigation<RegistrationGraph>(startDestination = LoginRoute) {
        composable<LoginRoute> { LoginRoute() }

        composable<SignInRoute> { SignInRoute() }
    }
}
