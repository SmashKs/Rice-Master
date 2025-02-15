package taiwan.no.one.ricemaster.registration.presentation.viewmodel.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Provided
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import taiwan.no.one.ricemaster.registration.data.model.SignInInfoModel
import taiwan.no.one.ricemaster.registration.data.repository.AuthRepo
import taiwan.no.one.ricemaster.registration.data.repository.SignInFormRepo
import taiwan.no.one.ricemaster.registration.presentation.entity.SignInInfoEntity
import taiwan.no.one.ricemaster.registration.presentation.entity.SignInUiState
import taiwan.no.one.ricemaster.registration.presentation.entity.SignInUiState.Input
import taiwan.no.one.ricemaster.registration.presentation.entity.SignInUiState.ThirdPartyMethod
import taiwan.no.one.ricemaster.registration.presentation.entity.SocialIcon
import taiwan.no.one.ricemaster.registration.presentation.entity.SocialIcon.FACEBOOK
import taiwan.no.one.ricemaster.registration.presentation.entity.SocialIcon.GOOGLE
import taiwan.no.one.ricemaster.registration.presentation.entity.SocialIcon.TWITTER
import taiwan.no.one.ricemaster.registration.presentation.entity.mapper.toEntity
import taiwan.no.one.ricemaster.registration.presentation.handler.SignInHandler
import taiwan.no.one.ricemaster.registration.presentation.navigation.SignInNavEvent
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.signin.SignInEvent.DoneLoginMethod
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.signin.SignInEvent.Execute
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.signin.SignInEvent.NavigateSignUp
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.signin.SignInEvent.SignIn
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.signin.SignInEvent.UpdateEmail
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.signin.SignInEvent.UpdatePassword
import taiwan.no.one.ricemaster.ui.event.EventHandler
import taiwan.no.one.ricemaster.user.repository.UserRepo

@KoinViewModel
internal class SignInViewModel(
    private val userFormRepo: SignInFormRepo,
    private val authRepo: AuthRepo,
    @Provided private val userRepo: UserRepo,
) : ViewModel(), EventHandler<SignInEvent>, KoinComponent {
    private val googleSignInHandler: SignInHandler by inject(qualifier = named("google"))
    private val facebookSignInHandler: SignInHandler by inject(qualifier = named("facebook"))
    private val twitterSignInHandler: SignInHandler by inject(qualifier = named("twitter"))
    private val loginMethodFlow: MutableStateFlow<SocialIcon?> = MutableStateFlow(null)
    private val signInFlow: Flow<SignInInfoEntity> = userFormRepo.observeSignInFlow().map(SignInInfoModel::toEntity)
    private val _navSharedFlow: MutableSharedFlow<SignInNavEvent> = MutableSharedFlow()
    val navSharedFlow: SharedFlow<SignInNavEvent> = _navSharedFlow

    val state = combine(signInFlow, loginMethodFlow) { model, socialIcon ->
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
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = SignInUiState.Init,
    )

    override fun handleEvent(event: SignInEvent) {
        when (event) {
            NavigateSignUp -> viewModelScope.launch { _navSharedFlow.emit(SignInNavEvent.NavigateToSignUp) }
            is SignIn -> viewModelScope.launch { authRepo.signIn() }
            is UpdateEmail -> userFormRepo.updateEmail(event.email)
            is UpdatePassword -> userFormRepo.updatePassword(event.password)
            is Execute -> viewModelScope.launch { loginMethodFlow.emit(event.icon) }
            DoneLoginMethod -> viewModelScope.launch { loginMethodFlow.emit(null) }
        }
    }
}
