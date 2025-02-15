package taiwan.no.one.ricemaster.registration.presentation.entity

import androidx.compose.runtime.Stable

@Stable
sealed interface SignUpUiState {
    val email: String
    val password: String
    val confirmPassword: String

    data object Init : SignUpUiState {
        override val email: String = ""
        override val password: String = ""
        override val confirmPassword: String = ""
    }

    data class Input(
        override val email: String,
        override val password: String,
        override val confirmPassword: String,
    ) : SignUpUiState
}
