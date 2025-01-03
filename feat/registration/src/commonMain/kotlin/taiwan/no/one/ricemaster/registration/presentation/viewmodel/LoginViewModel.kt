package taiwan.no.one.ricemaster.registration.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import org.koin.core.component.KoinComponent
import taiwan.no.one.ricemaster.registration.data.RegistrationRepo
import taiwan.no.one.ricemaster.registration.domain.usecase.GoogleLoginUseCase
import taiwan.no.one.ricemaster.registration.presentation.entity.LoginUiState
import taiwan.no.one.ricemaster.registration.presentation.entity.LoginUiState.Input
import taiwan.no.one.ricemaster.registration.presentation.entity.LoginUiState.Twitter
import taiwan.no.one.ricemaster.registration.presentation.entity.SocialIcon
import taiwan.no.one.ricemaster.registration.presentation.entity.SocialIcon.FACEBOOK
import taiwan.no.one.ricemaster.registration.presentation.entity.SocialIcon.GOOGLE
import taiwan.no.one.ricemaster.registration.presentation.entity.SocialIcon.INSTAGRAM
import taiwan.no.one.ricemaster.registration.presentation.entity.SocialIcon.TWITTER
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.LoginEvent.DebugPrintData
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.LoginEvent.DoneLoginMethod
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.LoginEvent.Execute
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.LoginEvent.Login
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.LoginEvent.SignUp
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.LoginEvent.UpdateEmail
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.LoginEvent.UpdatePassword
import taiwan.no.one.ricemaster.ui.event.EventHandler

@KoinViewModel
internal class LoginViewModel(
    private val registrationRepo: RegistrationRepo,
    private val googleLoginUseCase: GoogleLoginUseCase,
) : ViewModel(), EventHandler<LoginEvent>, KoinComponent {
    private val loginMethodFlow: MutableStateFlow<SocialIcon?> = MutableStateFlow(null)
    private val registrationFlow = registrationRepo.observeLoginFlow()
    val state = combine(registrationFlow, loginMethodFlow) { model, socialIcon ->
        when (socialIcon) {
            TWITTER -> Twitter
            GOOGLE -> TODO()
            FACEBOOK -> TODO()
            INSTAGRAM -> TODO()
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
            DebugPrintData -> viewModelScope.launch {
                println("=================================================")
                println(registrationRepo.observeLoginFlow().first().toString())
                println("=================================================")
            }
            SignUp -> viewModelScope.launch { registrationRepo.createUser() }
            Login -> viewModelScope.launch {
                googleLoginUseCase.invoke().onSuccess {
                    println("=================================================")
                    println("doneeeeeeeeeeeeeeeeeeeeeeee")
                    println("=================================================")
                }.onFailure {
                    println("=================================================")
                    println(it)
                    println("=================================================")
                }
            }
            is UpdateEmail -> registrationRepo.updateEmail(event.email)
            is UpdatePassword -> registrationRepo.updatePassword(event.password)
            is Execute -> viewModelScope.launch { loginMethodFlow.emit(event.icon) }
            DoneLoginMethod -> viewModelScope.launch { loginMethodFlow.emit(null) }
        }
    }
}
