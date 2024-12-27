package taiwan.no.one.ricemaster.registration.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import taiwan.no.one.ricemaster.registration.data.RegistrationRepo
import taiwan.no.one.ricemaster.registration.presentation.entity.LoginUiState
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.LoginEvent.DebugPrintData
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.LoginEvent.UpdateEmail
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.LoginEvent.UpdatePassword
import taiwan.no.one.ricemaster.ui.event.EventHandler

@KoinViewModel
class LoginViewModel(
    private val registrationRepo: RegistrationRepo,
) : ViewModel(), EventHandler<LoginEvent> {
    val state = registrationRepo
        .observeLoginFlow()
        .map {
            LoginUiState.Input(
                email = it.email,
                password = it.password,
            )
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = LoginUiState.Init(),
        )

    init {
    }

    override fun handleEvent(event: LoginEvent) {
        when (event) {
            DebugPrintData -> viewModelScope.launch {
                println("=================================================")
                println(registrationRepo.observeLoginFlow().first().toString())
                println("=================================================")
            }

            is UpdateEmail -> registrationRepo.updateEmail(event.email)

            is UpdatePassword -> registrationRepo.updatePassword(event.password)
        }
    }
}
