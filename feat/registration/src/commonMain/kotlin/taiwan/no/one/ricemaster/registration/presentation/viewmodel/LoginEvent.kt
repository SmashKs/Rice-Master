package taiwan.no.one.ricemaster.registration.presentation.viewmodel

import taiwan.no.one.ricemaster.ui.event.Event

sealed interface LoginEvent : Event {
    data object DebugPrintData : LoginEvent

    data class UpdateEmail(val email: String) : LoginEvent

    data class UpdatePassword(val password: String) : LoginEvent
}
