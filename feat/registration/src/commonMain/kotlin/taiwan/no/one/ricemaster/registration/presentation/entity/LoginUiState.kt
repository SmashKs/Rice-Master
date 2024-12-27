package taiwan.no.one.ricemaster.registration.presentation.entity

sealed interface LoginUiState {
    val email: String
    val password: String

    data class Init(
        override val email: String = "",
        override val password: String = "",
    ) : LoginUiState

    data class Input(
        override val email: String,
        override val password: String,
    ) : LoginUiState
}
