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

    data object Twitter : LoginUiState {
        override val email: String = ""
        override val password: String = ""
    }
}
