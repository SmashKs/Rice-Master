package taiwan.no.one.ricemaster.registration.presentation.auth

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.auth.OAuthProvider
import com.google.firebase.auth.FirebaseAuth as AndroidFirebaseAuth

internal class AndroidFirebaseAuth : FirebaseAuth {
    private val auth = AndroidFirebaseAuth.getInstance()

    @Composable
    override fun signInWithTwitter(
        onSuccess: (GoogleUser) -> Unit,
        onError: (Exception) -> Unit,
    ) {
        val provider = OAuthProvider
            .newBuilder("twitter.com")
            .addCustomParameter("lang", "en")
            // Force re-consent.
            .addCustomParameter("prompt", "consent")
            .build()
        val activity = LocalContext.current as Activity

        auth
            .startActivityForSignInWithProvider(activity, provider)
            .addOnSuccessListener { authResult ->
                val user = authResult.user
                if (user != null) {
                    onSuccess(GoogleUser(user.uid, user.displayName.orEmpty(), user.email.orEmpty()))
                } else {
                    onError(Exception("Sign-in successful, but user is null"))
                }
            }.addOnFailureListener { exception ->
                onError(exception)
            }
    }
}
