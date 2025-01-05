package taiwan.no.one.ricemaster.registration.presentation.entity

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
        data object Google : ThirdPartyMethod {
            override val email: String = ""
            override val password: String = ""
        }

        data object Twitter : ThirdPartyMethod {
            override val email: String = ""
            override val password: String = ""
        }

        data object Facebook : ThirdPartyMethod {
            override val email: String = ""
            override val password: String = ""
        }

        data object Instagram : ThirdPartyMethod {
            override val email: String = ""
            override val password: String = ""
        }
    }
}
