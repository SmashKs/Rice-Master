package taiwan.no.one.ricemaster.registration.presentation.navigation

import androidx.navigation.NavController
import taiwan.no.one.ricemaster.navigation.NavEvent

sealed interface ForgotPasswordNavEvent : NavEvent {
    data object ResetPassword : ForgotPasswordNavEvent {
        override fun NavController.navigate() {
        }
    }
}
