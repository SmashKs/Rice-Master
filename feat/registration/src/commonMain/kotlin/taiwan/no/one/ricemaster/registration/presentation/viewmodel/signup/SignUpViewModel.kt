package taiwan.no.one.ricemaster.registration.presentation.viewmodel.signup

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import org.koin.android.annotation.KoinViewModel
import org.koin.core.component.KoinComponent
import taiwan.no.one.ricemaster.registration.data.repository.AuthRepo
import taiwan.no.one.ricemaster.registration.presentation.navigation.SingInNavEvent
import taiwan.no.one.ricemaster.ui.event.EventHandler

@KoinViewModel
internal class SignUpViewModel(
    private val authRepo: AuthRepo,
) : ViewModel(), EventHandler<SignUpEvent>, KoinComponent {
    private val registrationFlow: StateFlow<Unit> = MutableStateFlow(Unit)
    private val _navSharedFlow: MutableSharedFlow<SingInNavEvent> = MutableSharedFlow()
    val navSharedFlow: SharedFlow<SingInNavEvent> = _navSharedFlow

    override fun handleEvent(event: SignUpEvent) {
    }
}
