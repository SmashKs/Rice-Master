package taiwan.no.one.ricemaster.registration.presentation.viewmodel

import taiwan.no.one.ricemaster.registration.presentation.entity.SocialIcon
import taiwan.no.one.ricemaster.ui.event.Event

sealed interface LoginEvent : Event {
    data object DebugPrintData : LoginEvent

    data object Login : LoginEvent

    data object SignUp : LoginEvent

    data class UpdateEmail(val email: String) : LoginEvent

    data class UpdatePassword(val password: String) : LoginEvent

    data class Execute(val icon: SocialIcon) : LoginEvent
}
