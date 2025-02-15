package taiwan.no.one.ricemaster.registration.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.navOptions
import taiwan.no.one.ricemaster.navigation.NavEvent

sealed interface SignUpNavEvent : NavEvent {
    data object NavigateUp : SignUpNavEvent {
        override fun NavController.navigate() {
            navigateUp()
        }
    }

    data object NavigateToSignIn : SignUpNavEvent {
        override fun NavController.navigate() {
            navigate(
                route = SignInRoute,
                navOptions = navOptions { popBackStack() },
            )
        }
    }
}
