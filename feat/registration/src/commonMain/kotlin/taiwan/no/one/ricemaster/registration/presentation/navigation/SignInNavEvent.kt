package taiwan.no.one.ricemaster.registration.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.navOptions
import taiwan.no.one.ricemaster.navigation.NavEvent

sealed interface SignInNavEvent : NavEvent {
    data object NavigateUp : SignUpNavEvent {
        override fun NavController.navigate() {
            navigateUp()
        }
    }

    data object NavigateToSignUp : SignInNavEvent {
        override fun NavController.navigate() {
            navigate(
                route = SignUpRoute,
                navOptions = navOptions { popBackStack() },
            )
        }
    }

    data object NavigateToForgotPassword : SignInNavEvent {
        override fun NavController.navigate() {
            navigate(route = ForgotPasswordRoute)
        }
    }
}
