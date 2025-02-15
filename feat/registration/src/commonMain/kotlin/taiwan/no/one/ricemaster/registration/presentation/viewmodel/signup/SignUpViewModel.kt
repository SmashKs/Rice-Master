package taiwan.no.one.ricemaster.registration.presentation.viewmodel.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import org.koin.core.component.KoinComponent
import taiwan.no.one.ricemaster.registration.data.model.SignUpInfoModel
import taiwan.no.one.ricemaster.registration.data.repository.AuthRepo
import taiwan.no.one.ricemaster.registration.data.repository.SignUpFormRepo
import taiwan.no.one.ricemaster.registration.presentation.entity.SignUpInfoEntity
import taiwan.no.one.ricemaster.registration.presentation.entity.SignUpUiState
import taiwan.no.one.ricemaster.registration.presentation.entity.mapper.toEntity
import taiwan.no.one.ricemaster.registration.presentation.navigation.SignUpNavEvent
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.signup.SignUpEvent.GoBack
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.signup.SignUpEvent.GotoSignIn
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.signup.SignUpEvent.SignUp
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.signup.SignUpEvent.UpdateConfirmPassword
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.signup.SignUpEvent.UpdateEmail
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.signup.SignUpEvent.UpdatePassword
import taiwan.no.one.ricemaster.ui.event.EventHandler

@KoinViewModel
internal class SignUpViewModel(
    private val authRepo: AuthRepo,
    private val signUpFormRepo: SignUpFormRepo,
) : ViewModel(), EventHandler<SignUpEvent>, KoinComponent {
    private val signUpFlow: Flow<SignUpInfoEntity> = signUpFormRepo.observeSignUpFlow().map(SignUpInfoModel::toEntity)
    val state: StateFlow<SignUpUiState> = signUpFlow.map {
        SignUpUiState.Input(
            email = it.email,
            password = it.password,
            confirmPassword = it.confirmPassword,
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = SignUpUiState.Init,
    )
    private val _navSharedFlow: MutableSharedFlow<SignUpNavEvent> = MutableSharedFlow()
    val navSharedFlow: SharedFlow<SignUpNavEvent> = _navSharedFlow

    override fun handleEvent(event: SignUpEvent) {
        when (event) {
            GoBack -> viewModelScope.launch { _navSharedFlow.emit(SignUpNavEvent.NavigateUp) }
            GotoSignIn -> viewModelScope.launch { _navSharedFlow.emit(SignUpNavEvent.NavigateToSignIn) }
            SignUp -> viewModelScope.launch { authRepo.createUser() }
            is UpdateEmail -> signUpFormRepo.updateEmail(event.email)
            is UpdatePassword -> signUpFormRepo.updatePassword(event.password)
            is UpdateConfirmPassword -> signUpFormRepo.updateConfirmPassword(event.password)
        }
    }
}
