package taiwan.no.one.ricemaster.registration.presentation.viewmodel.signin

import taiwan.no.one.ricemaster.registration.presentation.entity.SocialIcon
import taiwan.no.one.ricemaster.ui.event.Event

sealed interface SignInEvent : Event {
    data object GotoSignUp : SignInEvent

    data object GotoForgotPassword : SignInEvent

    data object SignIn : SignInEvent

    data class UpdateEmail(val email: String) : SignInEvent

    data class UpdatePassword(val password: String) : SignInEvent

    data class Execute(val icon: SocialIcon) : SignInEvent

    data object DoneLoginMethod : SignInEvent
}
