package taiwan.no.one.ricemaster.registration.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import taiwan.no.one.ricemaster.registration.data.repository.AuthRepo
import taiwan.no.one.ricemaster.registration.data.repository.UserFormRepo
import taiwan.no.one.ricemaster.registration.presentation.entity.LoginUiState
import taiwan.no.one.ricemaster.registration.presentation.entity.LoginUiState.Input
import taiwan.no.one.ricemaster.registration.presentation.entity.LoginUiState.ThirdPartyMethod
import taiwan.no.one.ricemaster.registration.presentation.entity.SocialIcon
import taiwan.no.one.ricemaster.registration.presentation.entity.SocialIcon.FACEBOOK
import taiwan.no.one.ricemaster.registration.presentation.entity.SocialIcon.GOOGLE
import taiwan.no.one.ricemaster.registration.presentation.entity.SocialIcon.TWITTER
import taiwan.no.one.ricemaster.registration.presentation.handler.SignInHandler
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.LoginEvent.DoneLoginMethod
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.LoginEvent.Execute
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.LoginEvent.Login
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.LoginEvent.SignUp
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.LoginEvent.UpdateEmail
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.LoginEvent.UpdatePassword
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.LoginEvent.UpdateUserEmail
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.LoginEvent.UpdateUserPassword
import taiwan.no.one.ricemaster.ui.event.EventHandler
import taiwan.no.one.ricemaster.user.repository.UserRepo

@KoinViewModel
internal class LoginViewModel(
    private val userFormRepo: UserFormRepo,
    private val registrationRepo: AuthRepo,
    private val userRepo: UserRepo,
) : ViewModel(), EventHandler<LoginEvent>, KoinComponent {
    private val googleSignInHandler: SignInHandler by inject(qualifier = named("google"))
    private val facebookSignInHandler: SignInHandler by inject(qualifier = named("facebook"))
    private val twitterSignInHandler: SignInHandler by inject(qualifier = named("twitter"))
    private val loginMethodFlow: MutableStateFlow<SocialIcon?> = MutableStateFlow(null)
    private val registrationFlow = userFormRepo.observeLoginFlow()

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
        initialValue = LoginUiState.Init,
    )

    override fun handleEvent(event: LoginEvent) {
        when (event) {
            SignUp -> viewModelScope.launch { registrationRepo.createUser() }
            is Login -> viewModelScope.launch { registrationRepo.signIn() }
            is UpdateEmail -> userFormRepo.updateEmail(event.email)
            is UpdatePassword -> userFormRepo.updatePassword(event.password)
            is Execute -> viewModelScope.launch { loginMethodFlow.emit(event.icon) }
            DoneLoginMethod -> viewModelScope.launch { loginMethodFlow.emit(null) }
            UpdateUserEmail -> viewModelScope.launch { userRepo.updateEmail("pokkbaby+jp@gmail.com") }
            UpdateUserPassword -> viewModelScope.launch { userRepo.updatePassword("000000") }
        }
    }
}
