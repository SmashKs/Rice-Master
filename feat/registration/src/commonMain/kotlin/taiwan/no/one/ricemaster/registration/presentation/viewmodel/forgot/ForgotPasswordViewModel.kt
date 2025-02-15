package taiwan.no.one.ricemaster.registration.presentation.viewmodel.forgot

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import org.koin.android.annotation.KoinViewModel
import org.koin.core.component.KoinComponent
import taiwan.no.one.ricemaster.registration.data.repository.AuthRepo
import taiwan.no.one.ricemaster.registration.presentation.navigation.ForgotPasswordNavEvent
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.forgot.ForgotPasswordEvent.Request
import taiwan.no.one.ricemaster.ui.event.EventHandler

@KoinViewModel
internal class ForgotPasswordViewModel(
    private val authRepo: AuthRepo,
) : ViewModel(), EventHandler<ForgotPasswordEvent>, KoinComponent {
    private val _navSharedFlow: MutableSharedFlow<ForgotPasswordNavEvent> = MutableSharedFlow()
    val navSharedFlow: SharedFlow<ForgotPasswordNavEvent> = _navSharedFlow

    override fun handleEvent(event: ForgotPasswordEvent) {
        when (event) {
            is Request -> TODO()
        }
    }
}
