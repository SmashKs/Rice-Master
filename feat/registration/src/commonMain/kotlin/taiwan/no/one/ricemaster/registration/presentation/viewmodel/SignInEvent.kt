package taiwan.no.one.ricemaster.registration.presentation.viewmodel

import taiwan.no.one.ricemaster.registration.presentation.entity.SocialIcon
import taiwan.no.one.ricemaster.ui.event.Event

sealed interface SignInEvent : Event {
    data object SignUp : SignInEvent

    data object Login : SignInEvent

    data class UpdateEmail(val email: String) : SignInEvent

    data class UpdatePassword(val password: String) : SignInEvent

    data class Execute(val icon: SocialIcon) : SignInEvent

    data object DoneLoginMethod : SignInEvent
}
