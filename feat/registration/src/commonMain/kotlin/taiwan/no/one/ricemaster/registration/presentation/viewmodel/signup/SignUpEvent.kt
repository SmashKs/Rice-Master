package taiwan.no.one.ricemaster.registration.presentation.viewmodel.signup

import taiwan.no.one.ricemaster.ui.event.Event

sealed interface SignUpEvent : Event {
    data object GoBack : SignUpEvent

    data object GotoSignIn : SignUpEvent

    data object SignUp : SignUpEvent

    data class UpdateEmail(val email: String) : SignUpEvent

    data class UpdatePassword(val password: String) : SignUpEvent

    data class UpdateConfirmPassword(val password: String) : SignUpEvent
}
