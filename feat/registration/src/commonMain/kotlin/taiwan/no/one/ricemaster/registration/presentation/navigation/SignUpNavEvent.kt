package taiwan.no.one.ricemaster.registration.presentation.navigation

import androidx.navigation.NavController
import taiwan.no.one.ricemaster.navigation.NavEvent

sealed interface SignUpNavEvent : NavEvent {
    data object NavigateToSignIn : SignUpNavEvent {
        override fun NavController.navigate() {
            navigate(SignInRoute)
        }
    }
}
