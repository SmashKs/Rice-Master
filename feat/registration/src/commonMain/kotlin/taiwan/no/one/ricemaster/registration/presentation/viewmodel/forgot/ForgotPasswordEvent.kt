package taiwan.no.one.ricemaster.registration.presentation.viewmodel.forgot

import taiwan.no.one.ricemaster.ui.event.Event

sealed interface ForgotPasswordEvent : Event {
    data class Request(val password: String) : ForgotPasswordEvent
}
