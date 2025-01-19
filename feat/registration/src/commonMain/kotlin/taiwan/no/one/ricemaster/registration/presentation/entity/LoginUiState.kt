package taiwan.no.one.ricemaster.registration.presentation.entity

import taiwan.no.one.ricemaster.registration.presentation.handler.SignInHandler

sealed interface LoginUiState {
    val email: String
    val password: String

    data object Init : LoginUiState {
        override val email: String = ""
        override val password: String = ""
    }

    data class Input(
        override val email: String,
        override val password: String,
    ) : LoginUiState

    sealed interface ThirdPartyMethod : LoginUiState {
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
