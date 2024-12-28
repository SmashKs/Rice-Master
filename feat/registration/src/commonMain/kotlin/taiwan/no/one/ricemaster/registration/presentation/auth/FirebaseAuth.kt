package taiwan.no.one.ricemaster.registration.presentation.auth

import androidx.compose.runtime.Composable

interface FirebaseAuth {
    @Composable
    fun signInWithTwitter(
        onSuccess: (GoogleUser) -> Unit,
        onError: (Exception) -> Unit,
    )
}
