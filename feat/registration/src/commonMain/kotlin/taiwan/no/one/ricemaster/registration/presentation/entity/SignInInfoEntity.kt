package taiwan.no.one.ricemaster.registration.presentation.entity

import androidx.compose.runtime.Stable

@Stable
data class SignInInfoEntity(
    val email: String,
    val password: String,
)
