package taiwan.no.one.ricemaster.registration.presentation.entity

import androidx.compose.runtime.Stable
import taiwan.no.one.ricemaster.registration.presentation.handler.SignInHandler

@Stable
sealed interface SignInUiState {
    val email: String
    val password: String

    data object Init : SignInUiState {
        override val email: String = ""
        override val password: String = ""
    }

    data class Input(
        override val email: String,
        override val password: String,
    ) : SignInUiState

    @Stable
    sealed interface ThirdPartyMethod : SignInUiState {
        val signInHandler: SignInHandler

        data class Google(
            override val signInHandler: SignInHandler,
        ) : ThirdPartyMethod {
            override val email: String = ""
            override val password: String = ""
        }

        data class Twitter(
            override val signInHandler: SignInHandler,
        ) : ThirdPartyMethod {
            override val email: String = ""
            override val password: String = ""
        }

        data class Facebook(
            override val signInHandler: SignInHandler,
        ) : ThirdPartyMethod {
            override val email: String = ""
            override val password: String = ""
        }
    }
}
