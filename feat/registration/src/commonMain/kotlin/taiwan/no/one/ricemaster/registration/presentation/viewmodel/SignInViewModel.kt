package taiwan.no.one.ricemaster.registration.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Provided
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import taiwan.no.one.ricemaster.registration.data.repository.AuthRepo
import taiwan.no.one.ricemaster.registration.data.repository.UserFormRepo
import taiwan.no.one.ricemaster.registration.presentation.entity.SignInUiState
import taiwan.no.one.ricemaster.registration.presentation.entity.SignInUiState.Input
import taiwan.no.one.ricemaster.registration.presentation.entity.SignInUiState.ThirdPartyMethod
import taiwan.no.one.ricemaster.registration.presentation.entity.SocialIcon
import taiwan.no.one.ricemaster.registration.presentation.entity.SocialIcon.FACEBOOK
import taiwan.no.one.ricemaster.registration.presentation.entity.SocialIcon.GOOGLE
import taiwan.no.one.ricemaster.registration.presentation.entity.SocialIcon.TWITTER
import taiwan.no.one.ricemaster.registration.presentation.handler.SignInHandler
import taiwan.no.one.ricemaster.registration.presentation.navigation.SingInNavEvent
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.SignInEvent.DoneLoginMethod
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.SignInEvent.Execute
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.SignInEvent.Login
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.SignInEvent.SignUp
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.SignInEvent.UpdateEmail
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.SignInEvent.UpdatePassword
import taiwan.no.one.ricemaster.ui.event.EventHandler
import taiwan.no.one.ricemaster.user.repository.UserRepo

@KoinViewModel
internal class SignInViewModel(
    private val userFormRepo: UserFormRepo,
    private val authRepo: AuthRepo,
    @Provided private val userRepo: UserRepo,
) : ViewModel(), EventHandler<SignInEvent>, KoinComponent {
    private val googleSignInHandler: SignInHandler by inject(qualifier = named("google"))
    private val facebookSignInHandler: SignInHandler by inject(qualifier = named("facebook"))
    private val twitterSignInHandler: SignInHandler by inject(qualifier = named("twitter"))
    private val loginMethodFlow: MutableStateFlow<SocialIcon?> = MutableStateFlow(null)
    private val registrationFlow = userFormRepo.observeSignInFlow()
    private val _navSharedFlow: MutableSharedFlow<SingInNavEvent> = MutableSharedFlow()
    val navSharedFlow: SharedFlow<SingInNavEvent> = _navSharedFlow

    val state = combine(registrationFlow, loginMethodFlow) { model, socialIcon ->
        when (socialIcon) {
            TWITTER -> ThirdPartyMethod.Twitter(twitterSignInHandler)
            GOOGLE -> ThirdPartyMethod.Google(googleSignInHandler)
            FACEBOOK -> ThirdPartyMethod.Facebook(facebookSignInHandler)
            else -> Input(
                email = model.email,
                password = model.password,
            )
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = SignInUiState.Init,
    )

    override fun handleEvent(event: SignInEvent) {
        when (event) {
            SignUp -> viewModelScope.launch { _navSharedFlow.emit(SingInNavEvent.NavigateToSingUp) }
            is Login -> viewModelScope.launch { authRepo.signIn() }
            is UpdateEmail -> userFormRepo.updateEmail(event.email)
            is UpdatePassword -> userFormRepo.updatePassword(event.password)
            is Execute -> viewModelScope.launch { loginMethodFlow.emit(event.icon) }
            DoneLoginMethod -> viewModelScope.launch { loginMethodFlow.emit(null) }
        }
    }
}
